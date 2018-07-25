package portal;

import auth.SimpleAuthProvider;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import portal.announcement.Announcement;
import portal.detail.Detail;
import portal.exam.Exam;
import portal.result.Result;

import javax.sound.sampled.Port;

import java.io.IOException;

import static org.junit.Assert.*;

public class PortalQueryTest
{
    private PortalQuery portalQuery;

    @Before
    public void setUp() throws Exception
    {
        // Log in first...
        SimpleAuthProvider authProvider = new SimpleAuthProvider();
        authProvider.performLogin(authProvider.requestLoginPage());

        // Then load the query object
        this.portalQuery = new PortalQuery();
    }

    @Test
    public void fetchMyExamResult() throws IOException
    {
        Result result = portalQuery.fetchMyExamResult();
        Assert.assertNotNull(result);
        Assert.assertFalse(result.getUserId().isEmpty());
    }

    @Test
    public void fetchMyExamTimetable() throws IOException
    {
        Exam exam = portalQuery.fetchMyExamTimetable();
        Assert.assertNotNull(exam);
    }

    @Test
    public void fetchMyDetail() throws IOException
    {
        Detail detail = portalQuery.fetchMyDetail();
        Assert.assertNotNull(detail);
        Assert.assertFalse(detail.getLastName().isEmpty());
    }

    @Test
    public void fetchAnnouncement() throws IOException
    {
        Announcement announcement = portalQuery.fetchAnnouncement();
        Assert.assertNotNull(announcement);
        Assert.assertFalse(announcement.getUserId().isEmpty());
    }
}