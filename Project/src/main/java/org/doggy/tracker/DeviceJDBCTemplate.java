package org.doggy.tracker;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DeviceJDBCTemplate implements DeviceDAO{
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	   
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(Integer userId, String code, String activationKey) {
		String SQL = "INSERT INTO Device (userId, code, activationKey) values (?, ?, ?)";
      
		jdbcTemplateObject.update( SQL, userId, code, activationKey);
		return;
   }
   
	public void delete(Integer id){
		String SQL = "DELETE FROM Device WHERE id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id );
		
		return;
	}
	
	public List<Device> listDevices() {
		String SQL = "SELECT * FROM DeviceReport";
		List <Device> device = jdbcTemplateObject.query(SQL, new DeviceMapper());
		
		return device;
	}
	
	public void update(String imei, Integer userId, String name){
		String SQL = "UPDATE Device SET userId = ? name = ? WHERE imei = ?";
		jdbcTemplateObject.update(SQL, userId, name);
		

		return;
	}

	@Override
	public Device getDevice(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}