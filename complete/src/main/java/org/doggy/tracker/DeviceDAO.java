package org.doggy.tracker;

import java.util.List;
import javax.sql.DataSource;

public interface DeviceDAO {

	   public void setDataSource(DataSource dataSource);
	   /** 
	    * This is the method to be used to create
	    * a record in the User table.
	    */
	   public void create(Integer userId, String code, String activationCode);
	   /** 
	    * This is the method to be used to list down
	    * a record from the User table corresponding
	    * to a passed user id.
	    */
	   public Device getDevice(Integer id);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Student table.
	    */
	   public List<Device> listDevices();
	   /** 
	    * This is the method to be used to delete
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public void delete(Integer id);
}
