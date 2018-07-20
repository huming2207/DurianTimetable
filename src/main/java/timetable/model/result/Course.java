package timetable.model.result;

public interface Course
{
    String getSubjectCode();

    void setSubjectCode(String subjectCode);

    String getDescription();

    void setDescription(String description);

    String getSemester();

    void setSemester(String semester);

    String getSemesterDescription();

    void setSemesterDescription(String semesterDescription);

    String getCampus();

    void setCampus(String campus);

    String getCampusDescription();

    void setCampusDescription(String campusDescription);
}
