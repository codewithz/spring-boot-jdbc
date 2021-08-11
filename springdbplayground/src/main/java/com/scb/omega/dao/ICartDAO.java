package com.scb.omega.dao;

import java.util.List;

import com.scb.omega.entities.Cart;

public interface ICartDAO {
	
	public String addCart(Cart c);
	public List<Cart> getCartForOrderId(int orderId);

}
