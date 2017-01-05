package org.doggy.tracker;

public class Device {
	
	private int id;
	private String code;
	private String activationKey;
	
	public int getid() {
		return id;
	}
	
	public void sed(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setName(String code) {
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
