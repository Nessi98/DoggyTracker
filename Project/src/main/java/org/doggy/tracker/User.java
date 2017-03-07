package org.doggy.tracker;

import javax.validation.constraints.NotNull;

public class User {
	
	private String firstName;
	private String lastName;
	@NotNull
	private String email;
	private String password;
	
	public User(){}
	
	public User(String firstName, String lastName, String email, String password){
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
//	@NotEmpty(message = "Please enter your password.") @Size(min = 6, max = 15, message = "Your password must between 6 and 15 characters")
