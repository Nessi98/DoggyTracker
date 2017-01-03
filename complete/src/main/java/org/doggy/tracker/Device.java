package org.doggy.tracker;

public class Device {
	
	private int deviceId;
	private String number;
	private String activationCode;
	
	public int getDeviceId() {
		return deviceId;
	}
	
	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	
	public void setDevice(String activationCode, String number){
		if(this.activationCode == activationCode && this.number == number ){
			//add the device in the User list
		}
	}
}
