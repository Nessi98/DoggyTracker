package org.doggy.tracker;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {
	
   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	   
      User user = new User();
      user.setid(rs.getInt("id"));
      user.setName(rs.getString("name"));
      user.setPassword(rs.getString("password"));
      user.setEmail(rs.getString("email"));
      
      return user;
   }
}