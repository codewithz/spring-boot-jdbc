package com.scb.omega.entities;

public class Cart 
{
	int id;
	int orderId;
	String product;
	int quantity;
	float total;
	
	public Cart() {
		super();
	}

	public Cart(int orderId, String product, int quantity, float total) {
		super();
		this.orderId = orderId;
		this.product = product;
		this.quantity = quantity;
		this.total = total;
	}

	public Cart(int id, int orderId, String product, int quantity, float total) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.product = product;
		this.quantity = quantity;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", orderId=" + orderId + ", product=" + product + ", quantity=" + quantity
				+ ", total=" + total + "]";
	}
	
	
	
	

}
