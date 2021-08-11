package com.scb.omega.entities;

import java.time.LocalDate;

public class Order 
{
	int id;
	String name;
	float amount;
	LocalDate orderdate;
	
	public Order() {
		super();
	}

	public Order(String name, float amount, LocalDate orderdate) {
		super();
		this.name = name;
		this.amount = amount;
		this.orderdate = orderdate;
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

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", amount=" + amount + ", orderdate=" + orderdate + "]";
	}
	
	
	
	

}
