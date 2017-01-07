package org.doggy.tracker;

public class DeviceReport {
	
	private int id;
	private String latitude;
	private String longitude;
	private String batteryLevel;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getBatteryLevel() {
		return batteryLevel;
	}

	public void setBatteryLevel(String batteryLevel) {
		this.batteryLevel = batteryLevel;
	}
	
	/* public type getDeviceInfo(){
	 * 
	 * }
	 * 
	public type getDeviceHistory(){
	   
	   
	}
	
	*/
}
