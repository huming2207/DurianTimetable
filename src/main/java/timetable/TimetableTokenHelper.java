package timetable;

import helpers.AuthCookieJar;
import helpers.Constant;
import helpers.Settings;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class TimetableTokenHelper
{
    private OkHttpClient httpClient;
    private Settings settings = Settings.getInstance();
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public TimetableTokenHelper()
    {
        this.httpClient = new OkHttpClient.Builder()
                .cookieJar(AuthCookieJar.getInstance())
                .build();
    }

    public String getTimetableToken()
    {
        Request request = new Request.Builder()
                .url("https://mytimetable.rmit.edu.au/even/student")
                .addHeader("User-Agent", settings.getSetting(Constant.SETTING_KEY_USER_AGENT))
                .build();

        try {
            Response response = httpClient.newCall(request).execute();
            String ssToken = response.request().url().queryParameterValue(0);
            logger.info("Ah-ha, got timetable token: " + ssToken);
            return ssToken; // Get the first parameter
        } catch (IOException e) {
            logger.error("Cannot get timetable token!");
            logger.error(e.toString());
            System.exit(1);
            return "";
        }
    }
}
