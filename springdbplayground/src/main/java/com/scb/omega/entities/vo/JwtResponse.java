package com.scb.omega.entities.vo;

public class JwtResponse 
{
	 private String token;
	 private String createdAt;
	 private String expiresOn;

	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JwtResponse(String token) {
		super();
		this.token = token;
	}
	
	

	public JwtResponse(String token, String createdAt, String expiresOn) {
		super();
		this.token = token;
		this.createdAt = createdAt;
		this.expiresOn = expiresOn;
	}

	public String getJwtToken() {
		return token;
	}

	public void setJwtToken(String token) {
		this.token = token;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getExpiresOn() {
		return expiresOn;
	}

	public void setExpiresOn(String expiresOn) {
		this.expiresOn = expiresOn;
	}
	
}