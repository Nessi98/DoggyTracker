package org.doggy.tracker;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DeviceReportJDBCTemplate  implements DeviceReportDAO{
	
	private JdbcTemplate jdbcTemplateObject;
	   
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(Integer deviceId, float latitude, float longitude, String batteryLevel) {		
		String SQL = "INSERT INTO DeviceReport (deviceId, latitude, longitude, batteryLevel) values (?, ?, ?, ?)";
      
		jdbcTemplateObject.update(SQL, deviceId, latitude, longitude, batteryLevel);
   }
   
	public void update(Integer deviceId, float latitude, float longitude, String batteryLevel){		
		String SQL = "UPDATE DeviceReport set latitude = ? longitude = ? batteryLevel = ? WHERE deviceId = ?";
	    jdbcTemplateObject.update(SQL, latitude, longitude, batteryLevel, deviceId);
	}
	
	
	public List<DeviceReport> listDeviceReports() {
		String SQL = "SELECT * FROM DeviceReport";
		List <DeviceReport> deviceReport = jdbcTemplateObject.query(SQL, new DeviceReportMapper());
		
		return deviceReport;
	}

	public DeviceReport getDeviceReport(Integer deviceId) {
		String SQL = "SELECT * FROM DeviceReport WHERE deviceId = ?";
	    
		DeviceReport deviceReport = jdbcTemplateObject.queryForObject(SQL, new Object[]{deviceId}, new DeviceReportMapper());
		return deviceReport;
	}

}