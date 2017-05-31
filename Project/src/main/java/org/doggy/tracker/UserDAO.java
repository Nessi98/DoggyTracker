package org.doggy.tracker;

import java.util.List;
import javax.sql.DataSource;

public interface UserDAO {

	   public void setDataSource(DataSource dataSource);

	   public void create(String firstName, String lastName, String email, String password);

	   public User getUser(String email);

	   public List<User> listUsers();

	   public void delete(Integer id);

	   public void updateByEmail(String newEmail, String oldEmail);
	   
	   public void updateByPassword(String newPassword, String email);
	   
	   public void updateByFirstName(String firstName, String email);
}
