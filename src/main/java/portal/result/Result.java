package portal.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Result
{

    @JsonProperty("timeStamp")
    private long timeStamp;

    @JsonProperty("lastUpdated")
    private String lastUpdated;

    @JsonProperty("termsAndResults")
    private List<Semester> termsAndResults;

    @JsonProperty("responseMessage")
    private String responseMessage;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("responseCode")
    private String responseCode;

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

    public void setTermsAndResults(List<Semester> termsAndResults)
    {
        this.termsAndResults = termsAndResults;
    }

    public List<Semester> getTermsAndResults()
    {
        return termsAndResults;
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

    @Override
    public String toString()
    {
        return
                "Result{" +
                        "timeStamp = '" + timeStamp + '\'' +
                        ",lastUpdated = '" + lastUpdated + '\'' +
                        ",termsAndResults = '" + termsAndResults + '\'' +
                        ",responseMessage = '" + responseMessage + '\'' +
                        ",userId = '" + userId + '\'' +
                        ",responseCode = '" + responseCode + '\'' +
                        "}";
    }
}