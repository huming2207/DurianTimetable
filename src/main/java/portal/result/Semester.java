package portal.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Semester
{

    @JsonProperty("subjects")
    private List<Subject> subjects;

    @JsonProperty("semesterName")
    private String semesterName;

    public void setSubjects(List<Subject> subjects)
    {
        this.subjects = subjects;
    }

    public List<Subject> getSubjects()
    {
        return subjects;
    }

    public void setSemesterName(String semesterName)
    {
        this.semesterName = semesterName;
    }

    public String getSemesterName()
    {
        return semesterName;
    }

    @Override
    public String toString()
    {
        return
                "Semester{" +
                        "subjects = '" + subjects + '\'' +
                        ",semesterName = '" + semesterName + '\'' +
                        "}";
    }
}