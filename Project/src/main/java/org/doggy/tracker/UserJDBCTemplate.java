package org.doggy.tracker;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO {
	
	private JdbcTemplate jdbcTemplateObject;
	   
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

   public void create(String firstName, String lastName, String email, String password) {
      String SQL = "INSERT INTO User (firstName, lastName, email, password) values (?, ?, ?, ?)";
      
      jdbcTemplateObject.update( SQL, firstName, lastName, email, password);
      return;
   }

   public User getUser(String email) {
      String SQL = "SELECT * FROM User WHERE email = ?";

      User user = jdbcTemplateObject.queryForObject(SQL, new Object[]{email}, new UserMapper());

      return user;
   }

   public List<User> listUsers() {
      String SQL = "SELECT * FROM User";
      List <User> users = jdbcTemplateObject.query(SQL, new UserMapper());
      
      return users;
   }

   public void delete(Integer id){
      String SQL = "DELETE FROM User WHERE id = ?";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }

   public void update(Integer id, String email){
      String SQL = "UPDATE User SET email = ? WHERE id = ?";
      jdbcTemplateObject.update(SQL, email, id);
      System.out.println("Updated Record with ID = " + id );
      
      return;
   }

}
