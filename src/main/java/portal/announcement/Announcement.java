package portal.announcement;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Announcement{

	@JsonProperty("timeStamp")
	private long timeStamp;

	@JsonProperty("responseMessage")
	private String responseMessage;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("announcements")
	private List<Message> messages;

	@JsonProperty("responseCode")
	private String responseCode;

	public void setTimeStamp(long timeStamp){
		this.timeStamp = timeStamp;
	}

	public long getTimeStamp(){
		return timeStamp;
	}

	public void setResponseMessage(String responseMessage){
		this.responseMessage = responseMessage;
	}

	public String getResponseMessage(){
		return responseMessage;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setMessages(List<Message> messages){
		this.messages = messages;
	}

	public List<Message> getMessages(){
		return messages;
	}

	public void setResponseCode(String responseCode){
		this.responseCode = responseCode;
	}

	public String getResponseCode(){
		return responseCode;
	}

	@Override
 	public String toString(){
		return 
			"Announcement{" + 
			"timeStamp = '" + timeStamp + '\'' + 
			",responseMessage = '" + responseMessage + '\'' + 
			",userId = '" + userId + '\'' + 
			",messages = '" + messages + '\'' +
			",responseCode = '" + responseCode + '\'' + 
			"}";
		}
}