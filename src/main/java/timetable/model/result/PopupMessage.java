package timetable.model.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PopupMessage
{

	@JsonProperty("msg")
	private String msg;

	@JsonProperty("success")
	private boolean success;

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setSuccess(boolean success)
	{
		this.success = success;
	}

	public boolean isSuccess()
	{
		return success;
	}
}