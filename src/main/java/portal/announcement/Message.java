package portal.announcement;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message
{

	@JsonProperty("important")
	private boolean important;

	@JsonProperty("expiryDate")
	private String expiryDate;

	@JsonProperty("read")
	private boolean read;

	@JsonProperty("releaseDate")
	private String releaseDate;

	@JsonProperty("announcementId")
	private int announcementId;

	@JsonProperty("title")
	private String title;

	@JsonProperty("content")
	private String content;

	public void setImportant(boolean important){
		this.important = important;
	}

	public boolean isImportant(){
		return important;
	}

	public void setExpiryDate(String expiryDate){
		this.expiryDate = expiryDate;
	}

	public String getExpiryDate(){
		return expiryDate;
	}

	public void setRead(boolean read){
		this.read = read;
	}

	public boolean isRead(){
		return read;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setAnnouncementId(int announcementId){
		this.announcementId = announcementId;
	}

	public int getAnnouncementId(){
		return announcementId;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"Message{" +
			"important = '" + important + '\'' + 
			",expiryDate = '" + expiryDate + '\'' + 
			",read = '" + read + '\'' + 
			",releaseDate = '" + releaseDate + '\'' + 
			",announcementId = '" + announcementId + '\'' + 
			",title = '" + title + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}