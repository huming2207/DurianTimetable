package auth;

import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Simple authentication provider
 *
 * It simulates the user login behaviour in the browser to get the tokens
 */
public class SimpleAuthProvider implements SsoCasAuthProvider
{
    private Properties prop = new Properties();
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

    @Override
    public void performLogin()
    {
        try {
            prop.load(new FileInputStream("app.properties"));
        } catch (IOException exception) {
            logger.error("Cannot load configuration file, reason comes below");
            logger.error(exception.getLocalizedMessage());
            return;
        }

        // Build the request with the specified user agent
        Request request = new Request.Builder()
                .url("https://sso-cas.rmit.edu.au/rmitcas/login")
                .addHeader("User-Agent", prop.getProperty("okhttp_ua"))
                .build();

        // Grab the login page and have a look at the hidden attributes
        httpClient.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                logger.error("OkHttp request failed");
                logger.error(e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                try(ResponseBody responseBody = response.body()) {
                    if(!response.isSuccessful()) throw new IOException("Unexpected response returned: " + response);
                    if (responseBody != null) {
                        submitLoginForm(parseLoginForm(responseBody.string()), new Callback()
                        {
                            @Override
                            public void onFailure(Call call, IOException e)
                            {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException
                            {

                            }
                        });
                    } else {
                        throw new IOException("Empty response: " + response);
                    }
                }
            }
        });
    }

    private RequestBody parseLoginForm(String loginPageHtml)
    {
        Document loginPage = Jsoup.parse(loginPageHtml);
        Element loginForm = loginPage.selectFirst("form#fm1");
        Elements hiddenLoginParams = loginForm.select("[type=\"hidden\"]");

        // Construct a form body
        FormBody.Builder formBuilder = new FormBody.Builder();

        // Add user ID and password into the form builder
        formBuilder.add("username", prop.getProperty("username"));
        formBuilder.add("password", prop.getProperty("password"));

        // Add hidden values into it (e.g. "lt" and "execution")
        for(Element formElement : hiddenLoginParams) {
            formBuilder.add(formElement.attributes().get("name"), formElement.attributes().get("value"));
        }

        return formBuilder.build();
    }

    private void submitLoginForm(RequestBody formBody, Callback callback)
    {
        // Build the request
        Request request = new Request.Builder()
                .url("https://sso-cas.rmit.edu.au/rmitcas/login")
                .addHeader("User-Agent", prop.getProperty("okhttp_ua"))
                .post(formBody)
                .build();


        // Perform login request
        httpClient.newCall(request).enqueue(callback);
    }
}
