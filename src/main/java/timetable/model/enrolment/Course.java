package timetable.model.enrolment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer;

import java.util.Map;

@JsonDeserialize(using = CollectionDeserializer.class)
public class Course
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

    @JsonProperty("subject_code")
    public String getSubjectCode()
    {
        return this.subjectCode;
    }

    @JsonProperty("subject_code")
    public void setSubjectCode(String subjectCode)
    {
        this.subjectCode = subjectCode;
    }

    @JsonProperty("description")
    public String getDescription()
    {
        return this.description;
    }

    @JsonProperty("description")
    public void setDescription(String description)
    {
        this.description = description;
    }

    @JsonProperty("faculty")
    public String getFaculty()
    {
        return this.faculty;
    }

    @JsonProperty("faculty")
    public void setFaculty(String faculty)
    {
        this.faculty = faculty;
    }

    @JsonProperty("semester")
    public String getSemester()
    {
        return this.semester;
    }

    @JsonProperty("semester")
    public void setSemester(String semester)
    {
        this.semester = semester;
    }

    @JsonProperty("semester_description")
    public String getSemesterDescription()
    {
        return this.semesterDescription;
    }

    @JsonProperty("semester_description")
    public void setSemesterDescription(String semesterDescription)
    {
        this.semesterDescription = semesterDescription;
    }

    @JsonProperty("campus")
    public String getCampus()
    {
        return this.campus;
    }

    @JsonProperty("campus")
    public void setCampus(String campus)
    {
        this.campus = campus;
    }

    @JsonProperty("campus_description")
    public String getCampusDescription()
    {
        return this.campusDescription;
    }

    @JsonProperty("campus_description")
    public void setCampusDescription(String campusDescription)
    {
        this.campusDescription = campusDescription;
    }

    @JsonProperty("showOnTT")
    public String getShowOnTT()
    {
        return this.showOnTT;
    }

    @JsonProperty("showOnTT")
    public void setShowOnTT(String showOnTT)
    {
        this.showOnTT = showOnTT;
    }

    @JsonProperty("display_subject_code")
    public String getDisplaySubjectCode()
    {
        return this.displaySubjectCode;
    }

    @JsonProperty("display_subject_code")
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
