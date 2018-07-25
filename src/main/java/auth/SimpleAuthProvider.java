package auth;

import helpers.AuthCookieJar;
import helpers.Constant;
import helpers.HttpFetcherSync;
import helpers.Settings;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Simple authentication provider
 *
 * It simulates the user login behaviour in the browser to performRequest the tokens
 */
public class SimpleAuthProvider
{
    private Settings settings = Settings.getInstance();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private OkHttpClient httpClient;

    public SimpleAuthProvider()
    {
        // Build HTTP client with cookie jar
        CookieJar cookieJar = AuthCookieJar.getInstance();
        this.httpClient = new OkHttpClient.Builder()
            .cookieJar(cookieJar)
            .build();
    }

    public String requestLoginPage()
    {
        // Build the request with the specified user agent
        Request request = new Request.Builder()
                .url(Constant.SSO_CAS_BASE_URL)
                .addHeader("User-Agent", settings.getSetting(Constant.SETTING_KEY_USER_AGENT))
                .build();

        // Grab the login page and have a look at the hidden attributes
        return HttpFetcherSync.performRequest(this.httpClient, request, this.logger);
    }

    public boolean performLogin(String loginPageHtml, String username, String password)
    {
        // If the user is logged in, return true to avoid a second one
        if(loginPageHtml.contains("Successful")) return true;

        // Build the request
        Request request = new Request.Builder()
                .url(Constant.SSO_CAS_BASE_URL)
                .addHeader("User-Agent", settings.getSetting(Constant.SETTING_KEY_USER_AGENT))
                .post(this.parseLoginForm(loginPageHtml, username, password))
                .build();

        // Validate login status
        return this.validateLoginPage(request);
    }

    public boolean performLogin(String loginPageHtml)
    {
        return this.performLogin(
                loginPageHtml,
                settings.getSetting(Constant.SETTING_KEY_USERNAME),
                settings.getSetting(Constant.SETTING_KEY_PASSWORD));
    }

    public boolean validateLoginToken()
    {
        // Build the request
        Request request = new Request.Builder()
                .url(Constant.SSO_CAS_BASE_URL)
                .addHeader("User-Agent", settings.getSetting(Constant.SETTING_KEY_USER_AGENT))
                .build();

        // Now validate the token
        return this.validateLoginPage(request);
    }

    private FormBody parseLoginForm(String loginPageHtml, String username, String password)
    {
        Document loginPage = Jsoup.parse(loginPageHtml);
        Element loginForm = loginPage.selectFirst("form#fm1");
        Elements hiddenLoginParams = loginForm.select("[type=\"hidden\"]");

        // Construct a form body
        FormBody.Builder formBuilder = new FormBody.Builder();

        // Add user ID and password into the form builder
        logger.info(String.format("Logging in with ID: %s...", username));
        formBuilder.add("username", username);
        formBuilder.add("password", password);

        // Add hidden values into it (e.g. "lt" and "execution")
        for(Element formElement : hiddenLoginParams) {
            logger.info(String.format("Got hidden item name: %s, value: %s",
                    formElement.attributes().get("name"),
                    formElement.attributes().get("value")));
            formBuilder.add(formElement.attributes().get("name"), formElement.attributes().get("value"));
        }

        return formBuilder.build();
    }

    /**
     * There will be several possibilities for a certain login case:
     *  - 1. Successful, server responses some info with "Login Successful"
     *  - 2. Successful but password is gonna to be expired some days later, server says "Your password expires ** days"
     *  - 3. Screwed, username/password was wrong
     *  - 4. Screwed, no response, probably IT Service staffs are evacuating due to another false fire alarm goes off.
     * @param request OKHttp Request object
     * @return True if login is successful.
     */
    private boolean validateLoginPage(Request request)
    {
        String loginPage = HttpFetcherSync.performRequest(this.httpClient, request, this.logger);

        if(loginPage != null && !loginPage.isEmpty()) {
            if(loginPage.contains("password expires")) {
                logger.warn("Yo, your password is gonna to be expired! It's time to change your password!");
                return true;
            } else {
                return loginPage.contains("Successful");
            }
        } else {
            return false; // Login page is null or empty
        }
    }
}
