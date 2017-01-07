package org.doggy.tracker;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

public class User {
	
	private int id;
    @NotNull
    @Size(min=2, max=30)
	private String name;
    @NotNull
    @Size(min=2, max=30)
	private String email;
    @NotNull
    @Size(min=2, max=30)
	private String password;
	
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
	
    public String toString() {
        return "Person(Name: " + this.name + ", Email: " + this.email + ", Password: " + this.password + ")"; 
    }
	
	public String changeName(String newName){
		this.name = newName;
		
		//update in the table 
		return name;
	}

}
