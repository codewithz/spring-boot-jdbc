package com.scb.omega.entities;

import java.time.LocalDate;

public class Customer 
{
	int id;
	String name;
	String email;
	long phone;
	boolean active;
	LocalDate birthdate;
	
	public Customer() {
		super();
	}

	public Customer(String name, String email, long phone, boolean active, LocalDate birthdate) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.active = active;
		this.birthdate = birthdate;
	}

	public Customer(int id, String name, String email, long phone, boolean active, LocalDate birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.active = active;
		this.birthdate = birthdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", active=" + active
				+ ", birthdate=" + birthdate + "]";
	}
	
	
	
	
	
	
	
}
