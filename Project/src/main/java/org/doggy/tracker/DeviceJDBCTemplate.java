package org.doggy.tracker;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DeviceJDBCTemplate implements DeviceDAO{
	
	private JdbcTemplate jdbcTemplateObject;
	   
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
		
	public void update(String name, Integer userId, int id){
		String SQL = "UPDATE Device SET userId = ? name = ? WHERE id = ?";
		jdbcTemplateObject.update(SQL, userId, name, id);
	
		return;
	}

	public Device getDevice(String imei) {
		String SQL = "SELECT * FROM Device WHERE imei = ?";
		Device device = jdbcTemplateObject.queryForObject(SQL, new Object[]{imei}, new DeviceMapper());
		
		return device;
	}
}