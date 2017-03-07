package org.doggy.tracker;

public class Device {
	

	private int userId;
	private String imei;
	private String name;
	private String activationKey;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getActivationKey() {
		return activationKey;
	}

	public void setActivationKey(String activationKey) {
		this.activationKey = activationKey;
	}
	

	public void setName(String name) {
		this.name = name;
		
	}
	
	public String getName(){
		return name;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
}
