package org.doggy.tracker;

public class Device {
	
	private int id;
	private int userId;
	private String imei;
	private String name;
	private String activationKey;
	
	public Device(int id, int userId, String name, String activationKey, String imei){
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.imei = imei;
		this.activationKey = activationKey;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
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
