package org.doggy.tracker;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserJDBCTemplate implements UserDAO {
	
   private DataSource dataSource;
   private JdbcTemplate jdbcTemplateObject;
   
   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
   }

   public void create(String name, String email, String password) {
      String SQL = "INSERT INTO Users (name, email, password) values (?, ?, ?)";
      
      jdbcTemplateObject.update( SQL, name, email, password);
      return;
   }

   public User getUser(Integer id) {
      String SQL = "SELECT * FROM Users WHERE id = ?";
      User user = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{id}, new UserMapper());
      return user;
   }

   public List<User> listUsers() {
      String SQL = "SELECT * FROM Users";
      List <User> users = jdbcTemplateObject.query(SQL, new UserMapper());
      return users;
   }

   public void delete(Integer id){
      String SQL = "DELETE FROM User WHERE id = ?";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }

   public void update(Integer id, String name){
      String SQL = "UPDATE users set name = ? WHERE id = ?";
      jdbcTemplateObject.update(SQL, name, id);
      System.out.println("Updated Record with ID = " + id );
      return;
   }

}
