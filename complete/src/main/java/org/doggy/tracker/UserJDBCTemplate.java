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
      String SQL = "insert into User (name, password, email) values (?, ?, ?)";
      
      jdbcTemplateObject.update( SQL, name, password, email);
      //System.out.println("Created Record Name = " + name + " Age = " + age);
      return;
   }

   public User getUser(Integer id) {
      String SQL = "select * from User where id = ?";
      User user = jdbcTemplateObject.queryForObject(SQL, 
                        new Object[]{id}, new UserMapper());
      return user;
   }

   public List<User> listUsers() {
      String SQL = "select * from Student";
      List <User> users = jdbcTemplateObject.query(SQL, 
                                new UserMapper());
      return users;
   }

   public void delete(Integer id){
      String SQL = "delete from User where id = ?";
      jdbcTemplateObject.update(SQL, id);
      System.out.println("Deleted Record with ID = " + id );
      return;
   }

   public void update(Integer userId, String name){
      String SQL = "update Student set age = ? where id = ?";
      jdbcTemplateObject.update(SQL, name, userId);
      System.out.println("Updated Record with ID = " + userId );
      return;
   }

}
