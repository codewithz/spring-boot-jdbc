package com.scb.omega.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.scb.omega.dao.ICartDAO;
import com.scb.omega.entities.Cart;
import com.scb.omega.utils.Status;

@Repository
public class CartDAO implements ICartDAO
{	
	@Autowired
	JdbcTemplate template;

	@Override
	public String addCart(Cart c) {
		String result="";
		String query="Insert into cart(orderid,product,quantity,total) values (?,?,?,?)";
		int rowInserted=template.update(query,c.getOrderId(),c.getProduct(),c.getQuantity(),c.getTotal());
		if(rowInserted==1)
		{
			result=Status.SUCCESS;
		}
		else
		{
			result=Status.NOT_FOUND;
		}
		return result;
	}

	@Override
	public List<Cart> getCartForOrderId(int orderId) {
		List<Cart> list=new ArrayList<>();
		
		try
		{
			String query="Select id,orderid,product,total,quantity from cart where orderid=?";
			RowMapper<Cart> rowMapper=new CartRowMapper();
			list=template.query(query, rowMapper,orderId);
		}
		catch (Exception e) 
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
		
		
	}

}
