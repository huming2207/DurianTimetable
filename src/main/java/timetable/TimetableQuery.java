package timetable;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helpers.Constant;
import helpers.HttpFetcherSync;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import timetable.model.result.AllocatedCourse;
import timetable.model.result.EnrolledCourse;
import timetable.model.result.PopupMessage;

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
        String queryUrl = String.format("%s/student/%s/result/?ss=%s",
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

    public PopupMessage setActivity(String courseId, String activityId, String choiceId) throws IOException
    {
        String queryUrl = String.format("%s/student/changeActivity/?ss=%s", Constant.TIMETABLE_BASE_URL, this.ssToken);
        FormBody formBody = new FormBody.Builder()
                .add("token", "a")
                .add("student_code", this.studentId)
                .add("subject_code", courseId) // Subject (course) code, e.g. ISYS1085_1850_2595_AUSCY
                .add("activity_group_code", activityId) // Activity group (tutorial, lab or lecture) code, e.g. TUT01
                .add("activity_code", choiceId) // Activity code, i.e. the sequence code
                .build();

        Request request = new Request.Builder()
                .url(queryUrl)
                .addHeader("User-Agent", prop.getProperty(Constant.SETTING_KEY_USER_AGENT))
                .post(formBody)
                .build();

        String queryResult = HttpFetcherSync.performRequest(this.httpClient, request, this.logger);
        ObjectMapper objectMapper = new ObjectMapper();

        TypeReference<PopupMessage> courseType = new TypeReference<PopupMessage>() {};
        return objectMapper.readValue(queryResult, courseType);
    }
}
