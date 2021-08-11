package com.scb.omega.service;

import com.scb.omega.entities.Order;
import com.scb.omega.entities.vo.OrderCartVO;

public interface IOrderService 
{
	public int addOrder(Order o);
	public String placeOrder(OrderCartVO orderCartVO);
	public OrderCartVO getOrderById(int id);

}
