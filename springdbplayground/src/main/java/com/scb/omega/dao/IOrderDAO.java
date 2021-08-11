package com.scb.omega.dao;

import com.scb.omega.entities.Order;

public interface IOrderDAO {
	
	public int addOrder(Order o);
	public Order getOrderById(int id);

}
