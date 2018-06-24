package timetable.model.enrolment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Activity
{
    @JsonProperty("subject_code")
    private String subjectCode;

    @JsonProperty("activity_group_code")
    private String activityGroupCode;

    @JsonProperty("description")
    private String description;

    @JsonProperty("num_flagged_timeslots")
    private String numFlaggedTimeslots;

    @JsonProperty("status")
    private String status;

    @JsonProperty("auto_single")
    private String autoSingle;

    @JsonProperty("min_prefs")
    private Integer minPrefs;

    @JsonProperty("allow_justification")
    private String allowJustification;

    @JsonProperty("allow_waitlist")
    private String allowWaitlist;

    @JsonProperty("show_availability")
    private String showAvailability;

    @JsonProperty("act_cnt")
    private Integer actCnt;

    @JsonProperty("subject_code")
    public String getSubjectCode()
    {
        return subjectCode;
    }

    @JsonProperty("subject_code")
    public void setSubjectCode(String subjectCode)
    {
        this.subjectCode = subjectCode;
    }

    @JsonProperty("activity_group_code")
    public String getActivityGroupCode()
    {
        return activityGroupCode;
    }

    @JsonProperty("activity_group_code")
    public void setActivityGroupCode(String activityGroupCode)
    {
        this.activityGroupCode = activityGroupCode;
    }

    @JsonProperty("description")
    public String getDescription()
    {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description)
    {
        this.description = description;
    }

    @JsonProperty("num_flagged_timeslots")
    public String getNumFlaggedTimeslots()
    {
        return numFlaggedTimeslots;
    }

    @JsonProperty("num_flagged_timeslots")
    public void setNumFlaggedTimeslots(String numFlaggedTimeslots)
    {
        this.numFlaggedTimeslots = numFlaggedTimeslots;
    }

    @JsonProperty("status")
    public String getStatus()
    {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status)
    {
        this.status = status;
    }

    @JsonProperty("auto_single")
    public String getAutoSingle()
    {
        return autoSingle;
    }

    @JsonProperty("auto_single")
    public void setAutoSingle(String autoSingle)
    {
        this.autoSingle = autoSingle;
    }

    @JsonProperty("min_prefs")
    public Integer getMinPrefs()
    {
        return minPrefs;
    }

    @JsonProperty("min_prefs")
    public void setMinPrefs(Integer minPrefs)
    {
        this.minPrefs = minPrefs;
    }

    @JsonProperty("allow_justification")
    public String getAllowJustification()
    {
        return allowJustification;
    }

    @JsonProperty("allow_justification")
    public void setAllowJustification(String allowJustification)
    {
        this.allowJustification = allowJustification;
    }

    @JsonProperty("allow_waitlist")
    public String getAllowWaitlist()
    {
        return allowWaitlist;
    }

    @JsonProperty("allow_waitlist")
    public void setAllowWaitlist(String allowWaitlist)
    {
        this.allowWaitlist = allowWaitlist;
    }

    @JsonProperty("show_availability")
    public String getShowAvailability()
    {
        return showAvailability;
    }

    @JsonProperty("show_availability")
    public void setShowAvailability(String showAvailability)
    {
        this.showAvailability = showAvailability;
    }

    @JsonProperty("act_cnt")
    public Integer getActCnt()
    {
        return actCnt;
    }

    @JsonProperty("act_cnt")
    public void setActCnt(Integer actCnt)
    {
        this.actCnt = actCnt;
    }
}
