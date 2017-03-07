package org.doggy.tracker;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {
	
   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	   
      User user = new User();
      user.setFirstName(rs.getString("firstName"));
      user.setLastName(rs.getString("lastName"));
      user.setEmail(rs.getString("email"));
      user.setPassword(rs.getString("password"));
      
      return user;
   }
}