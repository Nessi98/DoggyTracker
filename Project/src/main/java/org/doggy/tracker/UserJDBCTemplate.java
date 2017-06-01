package org.doggy.tracker;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserJDBCTemplate implements UserDAO, UserDetailsService {
	
	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return getUser(username);
	}
	   
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

   public void updateByPassword(String password, String email){
      String SQL = "UPDATE User SET password = ? WHERE email = ?";
      jdbcTemplateObject.update(SQL, password, email);
      
      System.out.println("Updated Record with email = " + email);
      
      return;
   }
   
   public void updateByEmail(String newEmail, String oldEmail) {
	   String SQL = "UPDATE User SET email = ? WHERE email = ?";
	   jdbcTemplateObject.update(SQL, newEmail, oldEmail);
   }
   
   public void updateByFirstName(String firstName,String email) {
	   String SQL = "UPDATE User SET firstName = ? WHERE email = ?";
	   jdbcTemplateObject.update(SQL, firstName, email);
   }
   
   public void updateByLastName(String lastName,String email) {
	   String SQL = "UPDATE User SET lastName = ? WHERE email = ?";
	   jdbcTemplateObject.update(SQL, lastName, email);
   }
}