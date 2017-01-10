package org.doggy.tracker;

import java.util.List;
import javax.sql.DataSource;

public interface UserDAO {
	/** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   public void setDataSource(DataSource dataSource);
	   /** 
	    * This is the method to be used to create
	    * a record in the User table.
	    */
	   public void create(String name, String email, String password);
	   /** 
	    * This is the method to be used to list down
	    * a record from the User table corresponding
	    * to a passed user id.
	    */
	   public User getUser(Integer id);
	   /** 
	    * This is the method to be used to list down
	    * all the records from the Student table.
	    */
	   public List<User> listUsers();
	   /** 
	    * This is the method to be used to delete
	    * a record from the Student table corresponding
	    * to a passed student id.
	    */
	   public void delete(Integer id);
	   /** 
	    * This is the method to be used to update
	    * a record into the Student table.
	    */
	   public void update(Integer id, String name);
}