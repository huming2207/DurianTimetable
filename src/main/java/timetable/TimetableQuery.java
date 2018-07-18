package timetable;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.Constant;
import helpers.HttpFetcherSync;
import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import timetable.model.enrolment.AllocatedCourse;
import timetable.model.enrolment.EnrolledCourse;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class TimetableQuery
{
    private String ssToken;
    private String studentId;
    private Properties prop = new Properties();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private OkHttpClient httpClient;

    public TimetableQuery(String studentId, String ssToken, CookieJar cookieJar)
    {
        this.studentId = studentId;
        this.ssToken = ssToken;
        this.httpClient = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .build();
    }

    public Map<String, AllocatedCourse> fetchAllocatedCourses() throws IOException
    {
        String queryUrl = String.format("%s/student/%s/allocated/?ss=%s",
                Constant.TIMETABLE_BASE_URL, this.studentId, this.ssToken);

        Request request = new Request.Builder()
                .url(queryUrl)
                .addHeader("User-Agent", prop.getProperty(Constant.SETTING_KEY_USER_AGENT))
                .build();

        String allocatedCourseJson = HttpFetcherSync.performRequest(this.httpClient, request, this.logger);
        ObjectMapper objectMapper = new ObjectMapper();

        // Ask Jackson to deserialize the courses into Map<CourseNameInString, CourseObject>
        // The JSON format is something like this:
        // {"COSC1234_1810_1916_AUSCY||LEC01||01": {...}, "ISYS5678_1810_1916_AUSCY||LEC01||01": {...},  ...}
        TypeReference<Map<String, AllocatedCourse>> courseType = new TypeReference<Map<String, AllocatedCourse>>() {};
        return objectMapper.readValue(allocatedCourseJson, courseType);
    }

    public Map<String, EnrolledCourse> fetchEnrolledCourses() throws IOException
    {
        String queryUrl = String.format("%s/student/%s/enrolment/?ss=%s",
                Constant.TIMETABLE_BASE_URL, this.studentId, this.ssToken);

        Request request = new Request.Builder()
                .url(queryUrl)
                .addHeader("User-Agent", prop.getProperty(Constant.SETTING_KEY_USER_AGENT))
                .build();

        String allocatedCourseJson = HttpFetcherSync.performRequest(this.httpClient, request, this.logger);
        ObjectMapper objectMapper = new ObjectMapper();

        // Ask Jackson to deserialize the courses into Map<CourseNameInString, CourseObject>
        // The JSON format is something like this:
        // {"COSC1234_1850_1935_AUSCY": {...}, "ISYS5678_1850_1935_AUSCY": {...},  ...}
        TypeReference<Map<String, EnrolledCourse>> courseType = new TypeReference<Map<String, EnrolledCourse>>() {};
        return objectMapper.readValue(allocatedCourseJson, courseType);
    }

}
