package org.doggy.tracker;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class DeviceMapper implements RowMapper<Device> {
	
	   public Device mapRow(ResultSet rs, int rowNum) throws SQLException {
		   
	      Device device = new Device(rs.getInt("id"),rs.getInt("userId"), rs.getString("imei"),
	    		  rs.getString("name"), rs.getString("activationKey"));
	      
	      return device;
	   }
}