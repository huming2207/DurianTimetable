package portal.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subject
{

    @JsonProperty("unitsOfCredit")
    private double unitsOfCredit;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("grade")
    private String grade;

    @JsonProperty("name")
    private String name;

    @JsonProperty("catalogueNumber")
    private String catalogueNumber;

    @JsonProperty("term")
    private String term;

    @JsonProperty("classNumber")
    private String classNumber;

    @JsonProperty("courseDescription")
    private String courseDescription;

    @JsonProperty("availableFrom")
    private String availableFrom;

    @JsonProperty("mark")
    private String mark;

    public void setUnitsOfCredit(double unitsOfCredit)
    {
        this.unitsOfCredit = unitsOfCredit;
    }

    public double getUnitsOfCredit()
    {
        return unitsOfCredit;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGrade()
    {
        return grade;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setCatalogueNumber(String catalogueNumber)
    {
        this.catalogueNumber = catalogueNumber;
    }

    public String getCatalogueNumber()
    {
        return catalogueNumber;
    }

    public void setTerm(String term)
    {
        this.term = term;
    }

    public String getTerm()
    {
        return term;
    }

    public void setClassNumber(String classNumber)
    {
        this.classNumber = classNumber;
    }

    public String getClassNumber()
    {
        return classNumber;
    }

    public void setCourseDescription(String courseDescription)
    {
        this.courseDescription = courseDescription;
    }

    public String getCourseDescription()
    {
        return courseDescription;
    }

    public void setAvailableFrom(String availableFrom)
    {
        this.availableFrom = availableFrom;
    }

    public String getAvailableFrom()
    {
        return availableFrom;
    }

    public void setMark(String mark)
    {
        this.mark = mark;
    }

    public String getMark()
    {
        return mark;
    }

    @Override
    public String toString()
    {
        return
                "Subject{" +
                        "unitsOfCredit = '" + unitsOfCredit + '\'' +
                        ",subject = '" + subject + '\'' +
                        ",grade = '" + grade + '\'' +
                        ",name = '" + name + '\'' +
                        ",catalogueNumber = '" + catalogueNumber + '\'' +
                        ",term = '" + term + '\'' +
                        ",classNumber = '" + classNumber + '\'' +
                        ",courseDescription = '" + courseDescription + '\'' +
                        ",availableFrom = '" + availableFrom + '\'' +
                        ",mark = '" + mark + '\'' +
                        "}";
    }
}