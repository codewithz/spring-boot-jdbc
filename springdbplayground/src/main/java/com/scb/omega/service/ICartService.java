package com.scb.omega.service;

import java.util.List;

import com.scb.omega.entities.Cart;

public interface ICartService 
{
	public String addCart(Cart c);
	public List<Cart> getCartForOrderId(int orderId);
}
