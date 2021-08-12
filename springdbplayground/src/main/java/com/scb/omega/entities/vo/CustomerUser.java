package com.scb.omega.entities.vo;

public class CustomerUser 
{
	String username;
	String password;
	
	public CustomerUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	

	public CustomerUser() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	

}
