package org.doggy.tracker;

import java.util.List;

import javax.sql.DataSource;

public interface DeviceReportDAO {
	
	   public void setDataSource(DataSource dataSource);
	   /** 
	    * This is the method to be used to create
	    * a record in the User table.
	    */
	   public void create(String latitude, String longitude, String deviceBattery);
	   /** 
	    * This is the method to be used to list down
	    * a record from the User table corresponding
	    * to a passed user id.
	    */
	   public DeviceReport getDeviceReport(Integer id);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Student table.
	    */
	   public List<DeviceReport> listDeviceReports();
	   /** 
	    * This is the method to be used to delete
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public void delete(Integer id);
	   /** 
	    * This is the method to be used to update
	    * a record into the Student table.
	    */
	   public void update(Integer id, String latitude, String longitude, String deviceBattery);
}
