package portal.exam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExamEvent
{

    @JsonProperty("examDateGregorian")
    private long examDateGregorian;

    @JsonProperty("examDate")
    private String examDate;

    @JsonProperty("campusCode")
    private String campusCode;

    @JsonProperty("courseCode")
    private String courseCode;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("deskNumber")
    private String deskNumber;

    @JsonProperty("courseTitle")
    private String courseTitle;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("mobilePinId")
    private int mobilePinId;

    @JsonProperty("startTime")
    private String startTime;

    @JsonProperty("location")
    private String location;

    @JsonProperty("endTime")
    private String endTime;

    @JsonProperty("longitude")
    private double longitude;

    public void setExamDateGregorian(long examDateGregorian)
    {
        this.examDateGregorian = examDateGregorian;
    }

    public long getExamDateGregorian()
    {
        return examDateGregorian;
    }

    public void setExamDate(String examDate)
    {
        this.examDate = examDate;
    }

    public String getExamDate()
    {
        return examDate;
    }

    public void setCampusCode(String campusCode)
    {
        this.campusCode = campusCode;
    }

    public String getCampusCode()
    {
        return campusCode;
    }

    public void setCourseCode(String courseCode)
    {
        this.courseCode = courseCode;
    }

    public String getCourseCode()
    {
        return courseCode;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setDeskNumber(String deskNumber)
    {
        this.deskNumber = deskNumber;
    }

    public String getDeskNumber()
    {
        return deskNumber;
    }

    public void setCourseTitle(String courseTitle)
    {
        this.courseTitle = courseTitle;
    }

    public String getCourseTitle()
    {
        return courseTitle;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setMobilePinId(int mobilePinId)
    {
        this.mobilePinId = mobilePinId;
    }

    public int getMobilePinId()
    {
        return mobilePinId;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLocation()
    {
        return location;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    @Override
    public String toString()
    {
        return
                "ExamEvent{" +
                        "examDateGregorian = '" + examDateGregorian + '\'' +
                        ",examDate = '" + examDate + '\'' +
                        ",campusCode = '" + campusCode + '\'' +
                        ",courseCode = '" + courseCode + '\'' +
                        ",latitude = '" + latitude + '\'' +
                        ",deskNumber = '" + deskNumber + '\'' +
                        ",courseTitle = '" + courseTitle + '\'' +
                        ",duration = '" + duration + '\'' +
                        ",mobilePinId = '" + mobilePinId + '\'' +
                        ",startTime = '" + startTime + '\'' +
                        ",location = '" + location + '\'' +
                        ",endTime = '" + endTime + '\'' +
                        ",longitude = '" + longitude + '\'' +
                        "}";
    }
}