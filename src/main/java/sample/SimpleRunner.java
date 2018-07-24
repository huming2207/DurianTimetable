package sample;

import auth.SimpleAuthProvider;
import helpers.AuthCookieJar;
import okhttp3.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import timetable.TimetableQuery;
import timetable.TimetableTokenHelper;
import timetable.model.result.AllocatedCourse;

import java.io.IOException;
import java.util.Map;

public class SimpleRunner
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args)
    {
        SimpleRunner runner = new SimpleRunner();
        runner.run();
    }

    private void run()
    {
        SimpleAuthProvider authProvider = new SimpleAuthProvider();
        boolean loggedIn = authProvider.performLogin(authProvider.requestLoginPage());
        if(!loggedIn) {
            logger.error("Cannot log in!");
            System.exit(1);
        }

        // List the items in the cookie jar
        for(Cookie cookie : AuthCookieJar.getInstance().getCookies()) {
            logger.info("Got cookies: " + cookie.toString());
        }

        // Try fetch the current courses
        TimetableTokenHelper timetableTokenHelper = new TimetableTokenHelper();
        String ssToken = timetableTokenHelper.getTimetableToken();
        TimetableQuery timetableQuery = new TimetableQuery("s3554025", ssToken);
        try {
            Map<String, AllocatedCourse> allocatedCourses = timetableQuery.fetchAllocatedCourses();
            for(String name : allocatedCourses.keySet()) {
                logger.info("You've got course: " + name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
