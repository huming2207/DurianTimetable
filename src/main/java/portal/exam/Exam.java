package portal.exam;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Exam
{

    @JsonProperty("timeStamp")
    private long timeStamp;

    @JsonProperty("lastUpdated")
    private String lastUpdated;

    @JsonProperty("responseMessage")
    private String responseMessage;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("responseCode")
    private String responseCode;

    @JsonProperty("timetable")
    private List<ExamEvent> timetable;

    public void setTimeStamp(long timeStamp)
    {
        this.timeStamp = timeStamp;
    }

    public long getTimeStamp()
    {
        return timeStamp;
    }

    public void setLastUpdated(String lastUpdated)
    {
        this.lastUpdated = lastUpdated;
    }

    public String getLastUpdated()
    {
        return lastUpdated;
    }

    public void setResponseMessage(String responseMessage)
    {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage()
    {
        return responseMessage;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setResponseCode(String responseCode)
    {
        this.responseCode = responseCode;
    }

    public String getResponseCode()
    {
        return responseCode;
    }

    public void setTimetable(List<ExamEvent> timetable)
    {
        this.timetable = timetable;
    }

    public List<ExamEvent> getTimetable()
    {
        return timetable;
    }

    @Override
    public String toString()
    {
        return
                "Exam{" +
                        "timeStamp = '" + timeStamp + '\'' +
                        ",lastUpdated = '" + lastUpdated + '\'' +
                        ",responseMessage = '" + responseMessage + '\'' +
                        ",userId = '" + userId + '\'' +
                        ",responseCode = '" + responseCode + '\'' +
                        ",timetable = '" + timetable + '\'' +
                        "}";
    }
}