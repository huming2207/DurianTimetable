package timetable.model.enrolment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import timetable.model.converter.EnrolledCourseDeserializer;

import java.util.Map;

@JsonDeserialize(using = EnrolledCourseDeserializer.class)
public class EnrolledCourse implements Course
{
    @JsonProperty("subject_code")
    private String subjectCode;

    @JsonProperty("description")
    private String description;

    @JsonProperty("faculty")
    private String faculty;

    @JsonProperty("semester")
    private String semester;

    @JsonProperty("semester_description")
    private String semesterDescription;

    @JsonProperty("campus")
    private String campus;

    @JsonProperty("campus_description")
    private String campusDescription;

    @JsonProperty("showOnTT")
    private String showOnTT;

    @JsonProperty("display_subject_code")
    private String displaySubjectCode;

    @JsonIgnore
    private Map<String, Activity> activities;

    @Override
    public String getSubjectCode()
    {
        return this.subjectCode;
    }

    @Override
    public void setSubjectCode(String subjectCode)
    {
        this.subjectCode = subjectCode;
    }

    @Override
    public String getDescription()
    {
        return this.description;
    }

    @Override
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getFaculty()
    {
        return this.faculty;
    }

    public void setFaculty(String faculty)
    {
        this.faculty = faculty;
    }

    @Override
    public String getSemester()
    {
        return this.semester;
    }

    @Override
    public void setSemester(String semester)
    {
        this.semester = semester;
    }

    @Override
    public String getSemesterDescription()
    {
        return this.semesterDescription;
    }

    @Override
    public void setSemesterDescription(String semesterDescription)
    {
        this.semesterDescription = semesterDescription;
    }

    @Override
    public String getCampus()
    {
        return this.campus;
    }

    @Override
    public void setCampus(String campus)
    {
        this.campus = campus;
    }

    @Override
    public String getCampusDescription()
    {
        return this.campusDescription;
    }

    @Override
    public void setCampusDescription(String campusDescription)
    {
        this.campusDescription = campusDescription;
    }

    public String getShowOnTT()
    {
        return this.showOnTT;
    }

    public void setShowOnTT(String showOnTT)
    {
        this.showOnTT = showOnTT;
    }

    public String getDisplaySubjectCode()
    {
        return this.displaySubjectCode;
    }

    public void setDisplaySubjectCode(String displaySubjectCode)
    {
        this.displaySubjectCode = displaySubjectCode;
    }

    @JsonIgnore
    public void setActivities(Map<String, Activity> activities)
    {
        this.activities = activities;
    }

    @JsonIgnore
    public Map<String, Activity> getActivities()
    {
        return activities;
    }
}
