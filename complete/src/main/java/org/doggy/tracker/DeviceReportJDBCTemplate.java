package org.doggy.tracker;

import java.util.List;
import javax.sql.DataSource;
import java.text.DecimalFormat;
import org.springframework.jdbc.core.JdbcTemplate;

public class DeviceReportJDBCTemplate  implements DeviceReportDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	   
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String latitude, String longitude, String batteryLevel) {
		Float litersOfPetrol = Float.parseFloat(latitude);
		
		DecimalFormat df = new DecimalFormat("0.00");
		df.setMaximumFractionDigits(2);
		
		latitude = df.format(litersOfPetrol);
		
		litersOfPetrol = Float.parseFloat(longitude);
		longitude = df.format(litersOfPetrol);
		
		String SQL = "INSERT INTO DeviceReport (latitude, longitude, batteryLevel) values (?, ?, ?)";
      
		jdbcTemplateObject.update( SQL, latitude, longitude, batteryLevel);
		return;
   }
   
	public void update(Integer id, String latitude, String longitude, String batteryLevel){
		
		String SQL = "UPDATE DeviceReport set latitude = ? longitude = ? batteryLevel = ? WHERE id = ?";
	    jdbcTemplateObject.update(SQL, latitude, longitude, batteryLevel, id);
	    System.out.println("Updated Record with ID = " + id );
	    
	    return;
	}
	
	public void delete(Integer id){
		String SQL = "DELETE FROM DeviceReport WHERE id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id );
		
		return;
	}
	
	public List<DeviceReport> listDeviceReports() {
		String SQL = "SELECT * FROM DeviceReport";
		List <DeviceReport> deviceReport = jdbcTemplateObject.query(SQL, new DeviceReportMapper());
		
		return deviceReport;
	}

	@Override
	public DeviceReport getDeviceReport(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
