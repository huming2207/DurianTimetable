package portal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.AuthCookieJar;
import helpers.Constant;
import helpers.HttpFetcherSync;
import helpers.Settings;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import portal.announcement.Announcement;
import portal.detail.Detail;
import portal.exam.Exam;
import portal.result.Result;

import java.io.IOException;

public class PortalQuery
{
    private Settings settings = Settings.getInstance();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private OkHttpClient httpClient;

    public PortalQuery()
    {
        this.httpClient = new OkHttpClient.Builder().cookieJar(AuthCookieJar.getInstance()).build();
    }

    private <T> T fetchPortalApis(String endpoint, TypeReference<T> resultType) throws IOException
    {
        String queryUrl = String.format("%s%s", Constant.PORTAL_BASE_URL, endpoint);
        Request request = new Request.Builder()
                .url(queryUrl)
                .addHeader("User-Agent", settings.getSetting(Constant.SETTING_KEY_USER_AGENT))
                .build();

        String responseJson = HttpFetcherSync.performRequest(this.httpClient, request, this.logger);
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(responseJson, resultType);
    }

    public Result fetchMyExamResult() throws IOException
    {
        return this.fetchPortalApis("/myexamresults/new", new TypeReference<Result>() {});
    }

    public Exam fetchMyExamTimetable() throws IOException
    {
        return this.fetchPortalApis("/myexamtimetable", new TypeReference<Exam>() {});
    }

    public Detail fetchMyDetail() throws IOException
    {
        return this.fetchPortalApis("/mydetails", new TypeReference<Detail>() {});
    }

    public Announcement fetchAnnouncement() throws IOException
    {
        return this.fetchPortalApis("/announcements", new TypeReference<Announcement>() {});
    }
}
