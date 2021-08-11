package com.scb.omega.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import com.scb.omega.entities.Customer;

public class CustomerRowMapper implements RowMapper<Customer>
{

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		Customer c=new Customer();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setEmail(rs.getString("email"));
		c.setPhone(rs.getLong("phone"));
		c.setActive(rs.getBoolean("active"));
		c.setBirthdate(LocalDate.parse(rs.getString("birthdate")));
		
		return c;
	}
	

}
