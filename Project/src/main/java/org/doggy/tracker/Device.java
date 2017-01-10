package org.doggy.tracker;

public class Device {
	
	private int id;
	private int userId;
	private String code;
	private String activationKey;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}
	
	public void setDevice(String activationKey, String code){
		if(this.activationKey == activationKey && this.code == code ){
			//add the device in the User list
		}
	}
}
