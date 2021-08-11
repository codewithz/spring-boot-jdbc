package com.scb.omega.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.scb.omega.entities.Cart;

public class CartRowMapper implements RowMapper<Cart>
{

	@Override
	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Cart c=new Cart();
		c.setId(rs.getInt("id"));
		c.setOrderId(rs.getInt("orderid"));
		c.setProduct(rs.getString("product"));
		c.setQuantity(rs.getInt("quantity"));
		c.setTotal(rs.getFloat("total"));
		
		return c;
	}
	

}
