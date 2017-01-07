package org.doggy.tracker;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeviceReportMapper implements RowMapper<DeviceReport> {
	
	   public DeviceReport mapRow(ResultSet rs, int rowNum) throws SQLException {
		   
	      DeviceReport deviceReport = new DeviceReport();
	      deviceReport.setId(rs.getInt("id"));
	      deviceReport.setLatitude(rs.getString("latitude"));
	      deviceReport.setLongitude(rs.getString("longitude"));
	      deviceReport.setBatteryLevel(rs.getString("batteryLevel"));
	      
	      return deviceReport;
	   }
}