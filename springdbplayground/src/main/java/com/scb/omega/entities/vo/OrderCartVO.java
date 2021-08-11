package com.scb.omega.entities.vo;

import java.util.List;

import com.scb.omega.entities.Cart;

public class OrderCartVO 
{
	String name;
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




	@Override
	public String toString() {
		return "OrderCartVO [name=" + name + ", cart=" + cart + "]";
	}
	
	
	
	

}
