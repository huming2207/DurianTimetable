package portal;

import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class PortalQuery
{
    private String studentId;
    private Properties prop = new Properties();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private OkHttpClient httpClient;

    public PortalQuery(String studentId, CookieJar cookieJar)
    {
        this.studentId = studentId;
        this.httpClient = new OkHttpClient.Builder().cookieJar(cookieJar).build();
    }


}
