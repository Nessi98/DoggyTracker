package org.doggy.tracker;

public class User {
	
	private int id;
	private String name;
	private String password;
	private String email;
	
	public int getUserId() {
		return id;
	}

	public void setid(int userId) {
		this.id = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String changeName(String newName){
		this.name = newName;
		
		//update in the table 
		return name;
	}

}
