package timetable.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AllocatedCourse implements Course
{

    @JsonProperty("color")
    private String color;

    @JsonProperty("description")
    private String description;

    @JsonProperty("availability")
    private int availability;

    @JsonProperty("source")
    private String source;

    @JsonProperty("activity_size")
    private int activitySize;

    @JsonProperty("semester_description")
    private String semesterDescription;

    @JsonProperty("week_pattern")
    private String weekPattern;

    @JsonProperty("capacity")
    private String capacity;

    @JsonProperty("subject_description")
    private String subjectDescription;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("zone")
    private String zone;

    @JsonProperty("buffer")
    private int buffer;

    @JsonProperty("department")
    private String department;

    @JsonProperty("day_of_week")
    private String dayOfWeek;

    @JsonProperty("start_date")
    private String startDate;

    @JsonProperty("campus_description")
    private String campusDescription;

    @JsonProperty("subject_code")
    private String subjectCode;

    @JsonProperty("activity_group_code")
    private String activityGroupCode;

    @JsonProperty("student_count")
    private int studentCount;

    @JsonProperty("campus")
    private String campus;

    @JsonProperty("staff")
    private String staff;

    @JsonProperty("activity_code")
    private String activityCode;

    @JsonProperty("start_time")
    private String startTime;

    @JsonProperty("section_code")
    private String sectionCode;

    @JsonProperty("location")
    private String location;

    @JsonProperty("semester")
    private String semester;

    @JsonProperty("activityType")
    private String activityType;

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setAvailability(int availability)
    {
        this.availability = availability;
    }

    public int getAvailability()
    {
        return availability;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public String getSource()
    {
        return source;
    }

    public void setActivitySize(int activitySize)
    {
        this.activitySize = activitySize;
    }

    public int getActivitySize()
    {
        return activitySize;
    }

    public void setSemesterDescription(String semesterDescription)
    {
        this.semesterDescription = semesterDescription;
    }

    public String getSemesterDescription()
    {
        return semesterDescription;
    }

    public void setWeekPattern(String weekPattern)
    {
        this.weekPattern = weekPattern;
    }

    public String getWeekPattern()
    {
        return weekPattern;
    }

    public void setCapacity(String capacity)
    {
        this.capacity = capacity;
    }

    public String getCapacity()
    {
        return capacity;
    }

    public void setSubjectDescription(String subjectDescription)
    {
        this.subjectDescription = subjectDescription;
    }

    public String getSubjectDescription()
    {
        return subjectDescription;
    }

    public void setDuration(String duration)
    {
        this.duration = duration;
    }

    public String getDuration()
    {
        return duration;
    }

    public void setZone(String zone)
    {
        this.zone = zone;
    }

    public String getZone()
    {
        return zone;
    }

    public void setBuffer(int buffer)
    {
        this.buffer = buffer;
    }

    public int getBuffer()
    {
        return buffer;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDayOfWeek(String dayOfWeek)
    {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDayOfWeek()
    {
        return dayOfWeek;
    }

    public void setStartDate(String startDate)
    {
        this.startDate = startDate;
    }

    public String getStartDate()
    {
        return startDate;
    }

    public void setCampusDescription(String campusDescription)
    {
        this.campusDescription = campusDescription;
    }

    public String getCampusDescription()
    {
        return campusDescription;
    }

    public void setSubjectCode(String subjectCode)
    {
        this.subjectCode = subjectCode;
    }

    public String getSubjectCode()
    {
        return subjectCode;
    }

    public void setActivityGroupCode(String activityGroupCode)
    {
        this.activityGroupCode = activityGroupCode;
    }

    public String getActivityGroupCode()
    {
        return activityGroupCode;
    }

    public void setStudentCount(int studentCount)
    {
        this.studentCount = studentCount;
    }

    public int getStudentCount()
    {
        return studentCount;
    }

    public void setCampus(String campus)
    {
        this.campus = campus;
    }

    public String getCampus()
    {
        return campus;
    }

    public void setStaff(String staff)
    {
        this.staff = staff;
    }

    public String getStaff()
    {
        return staff;
    }

    public void setActivityCode(String activityCode)
    {
        this.activityCode = activityCode;
    }

    public String getActivityCode()
    {
        return activityCode;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setSectionCode(String sectionCode)
    {
        this.sectionCode = sectionCode;
    }

    public String getSectionCode()
    {
        return sectionCode;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLocation()
    {
        return location;
    }

    public void setSemester(String semester)
    {
        this.semester = semester;
    }

    public String getSemester()
    {
        return semester;
    }

    public void setActivityType(String activityType)
    {
        this.activityType = activityType;
    }

    public String getActivityType()
    {
        return activityType;
    }

    @Override
    public String toString()
    {
        return
            "AllocatedCourse{" +
            "color = '" + color + '\'' +
            ",description = '" + description + '\'' +
            ",availability = '" + availability + '\'' +
            ",source = '" + source + '\'' +
            ",activity_size = '" + activitySize + '\'' +
            ",semester_description = '" + semesterDescription + '\'' +
            ",week_pattern = '" + weekPattern + '\'' +
            ",capacity = '" + capacity + '\'' +
            ",subject_description = '" + subjectDescription + '\'' +
            ",duration = '" + duration + '\'' +
            ",zone = '" + zone + '\'' +
            ",buffer = '" + buffer + '\'' +
            ",department = '" + department + '\'' +
            ",day_of_week = '" + dayOfWeek + '\'' +
            ",start_date = '" + startDate + '\'' +
            ",campus_description = '" + campusDescription + '\'' +
            ",subject_code = '" + subjectCode + '\'' +
            ",activity_group_code = '" + activityGroupCode + '\'' +
            ",student_count = '" + studentCount + '\'' +
            ",campus = '" + campus + '\'' +
            ",staff = '" + staff + '\'' +
            ",activity_code = '" + activityCode + '\'' +
            ",start_time = '" + startTime + '\'' +
            ",section_code = '" + sectionCode + '\'' +
            ",location = '" + location + '\'' +
            ",semester = '" + semester + '\'' +
            ",activityType = '" + activityType + '\'' +
            "}";
    }
}