package portal.detail;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostalAddress{

	@JsonProperty("country")
	private String country;

	@JsonProperty("addressFull")
	private String addressFull;

	@JsonProperty("postcode")
	private String postcode;

	@JsonProperty("suburb")
	private String suburb;

	@JsonProperty("state")
	private String state;

	@JsonProperty("addressLine")
	private String addressLine;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setAddressFull(String addressFull){
		this.addressFull = addressFull;
	}

	public String getAddressFull(){
		return addressFull;
	}

	public void setPostcode(String postcode){
		this.postcode = postcode;
	}

	public String getPostcode(){
		return postcode;
	}

	public void setSuburb(String suburb){
		this.suburb = suburb;
	}

	public String getSuburb(){
		return suburb;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setAddressLine(String addressLine){
		this.addressLine = addressLine;
	}

	public String getAddressLine(){
		return addressLine;
	}

	@Override
 	public String toString(){
		return 
			"PostalAddress{" + 
			"country = '" + country + '\'' + 
			",addressFull = '" + addressFull + '\'' + 
			",postcode = '" + postcode + '\'' + 
			",suburb = '" + suburb + '\'' + 
			",state = '" + state + '\'' + 
			",addressLine = '" + addressLine + '\'' + 
			"}";
		}
}