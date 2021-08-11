package com.scb.omega.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scb.omega.dao.ICartDAO;
import com.scb.omega.dao.IOrderDAO;
import com.scb.omega.entities.Cart;
import com.scb.omega.entities.Order;
import com.scb.omega.entities.vo.OrderCartVO;
import com.scb.omega.service.IOrderService;
import com.scb.omega.utils.Status;

@Service
public class OrderService implements IOrderService
{
	@Autowired
	IOrderDAO orderDao;
	
	@Autowired
	ICartDAO cartDao;

	@Override
	public int addOrder(Order o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	@Transactional
	public String placeOrder(OrderCartVO orderCartVO) {
		
		List<Cart> cart=orderCartVO.getCart();
		
		float orderAmount=0;
		
		for(Cart cartItem:cart)
		{
			orderAmount=orderAmount+cartItem.getTotal();
		}
		
		Order o=new Order();
		o.setName(orderCartVO.getName());
		o.setOrderdate(LocalDate.now());
		o.setAmount(orderAmount);
		
		
		int orderID=orderDao.addOrder(o);
		
		//List<Cart> cart=orderCartVO.getCart();
		
		
		for(Cart cartItem:cart)
		{
			//cartItem=null;
			cartItem.setOrderId(orderID);
			String status=cartDao.addCart(cartItem);
			System.out.println(status);
		}
		
		return Status.SUCCESS;
	}

}
