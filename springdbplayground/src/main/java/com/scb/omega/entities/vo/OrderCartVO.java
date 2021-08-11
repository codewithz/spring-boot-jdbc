package com.scb.omega.entities.vo;

import java.time.LocalDate;
import java.util.List;

import com.scb.omega.entities.Cart;

public class OrderCartVO 
{
	int id;
	String name;
	LocalDate orderdate;
	float amount;

	List<Cart> cart;

	
	public OrderCartVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderCartVO(String name, List<Cart> cart) {
		super();
		this.name = name;
		this.cart = cart;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	public List<Cart> getCart() {
		return cart;
	}




	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}
	
	




	public LocalDate getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		this.orderdate = orderdate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "OrderCartVO [name=" + name + ", cart=" + cart + "]";
	}
	
	
	
	

}
