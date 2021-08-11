package com.scb.omega.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.scb.omega.dao.IOrderDAO;
import com.scb.omega.entities.Order;

@Repository
public class OrderDAO implements IOrderDAO
{
	@Autowired
	JdbcTemplate template;

	@Override
	public int addOrder(Order o) {
		
		String query="Insert into orders(name,amount,orderdate) values (?,?,?) returning id;";
		Object[] args=new Object[] {
				o.getName(),o.getAmount(),o.getOrderdate()
		};
		int generatedID=template.queryForObject(query,args,Integer.class);
		return generatedID;
	}

}
