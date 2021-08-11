package com.scb.omega.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.scb.omega.entities.Order;

public class OrderRowMapper implements RowMapper<Order>
{

	@Override
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Order o=new Order();
		o.setId(rs.getInt("id"));
		o.setName(rs.getString("name"));
		o.setAmount(rs.getFloat("amount"));
		o.setOrderdate(LocalDate.parse(rs.getString("orderdate")));
		
		return o;
	}
	

}
