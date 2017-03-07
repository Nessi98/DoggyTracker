package org.doggy.tracker;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class DeviceMapper implements RowMapper<Device> {
	
	   public Device mapRow(ResultSet rs, int rowNum) throws SQLException {
		   
	      Device device = new Device();
	      //device.setId(rs.getInt("id"));
	      device.setUserId(rs.getInt("userId"));
	      device.setImei(rs.getString("imei"));
	      device.setName(rs.getString("name"));
	      device.setActivationKey(rs.getString("activationKey"));
	      
	      return device;
	   }
}