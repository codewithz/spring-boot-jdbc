package com.scb.omega.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import com.scb.omega.dao.ICustomerDAO;
import com.scb.omega.entities.Customer;
import com.scb.omega.entities.vo.CustomerUser;
import com.scb.omega.utils.Status;

@Repository
public class CustomerDAO implements ICustomerDAO {
	
	@Autowired
	JdbcTemplate template;

	@Override
	public String addCustomer(Customer c) {
		String status="";
		try
		{
			
			String query="Insert into customer_scb(name,email,phone,active,birthdate) values (?,?,?,?,?);";
			int rowInserted=template.update(query,c.getName(),c.getEmail(),c.getPhone(),c.isActive(),c.getBirthdate());
			
			if(rowInserted==1)
			{
				status=Status.SUCCESS;
			}
			else
			{
				status=Status.NOT_FOUND;
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		}
		
		return status;
	}

	@Override
	public String updateCustomer(Customer c, int id) {
		String status="";
		try
		{
			
			String query="Update customer_scb set name=?,email=?,phone=?,active=?,birthdate=? where id=?;";
			int rowUpdated=template.update(query,c.getName(),c.getEmail(),c.getPhone(),c.isActive(),c.getBirthdate(),id);
			
			if(rowUpdated==1)
			{
				status=Status.SUCCESS;
			}
			else
			{
				status=Status.NOT_FOUND;
				
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		}
		
		return status;
	}

	@Override
	public String deleteCustomer(int id) {
		String status="";
		try
		{
			String query="Delete from customer_scb where id=?;";
			int rowDeleted=template.update(query,id);
			
			if(rowDeleted==1)
			{
				status=Status.SUCCESS;
			}
			else
			{
				status= Status.NOT_FOUND;
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		
		return status;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer c=null;
		try
		{
		String query="Select id,name,email,phone,active,birthdate from customer_scb where id=?";
		RowMapper<Customer> rowMapper=new CustomerRowMapper();
		c=template.queryForObject(query, rowMapper,id);
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		return c;
	}

	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> list=new ArrayList<>();
		try
		{
			String query="Select id,name,email,phone,active,birthdate from customer_scb";
			RowMapper<Customer> rowMapper=new CustomerRowMapper();
			list=template.query(query,rowMapper);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		return list;
	}

	@Override
	public List<Customer> getCustomersByActive(boolean activeStatus) {
		List<Customer> list=new ArrayList<>();
		try
		{
			String query="Select id,name,email,phone,active,birthdate from customer_scb where active=?";
			RowMapper<Customer> rowMapper=new CustomerRowMapper();
			list=template.query(query,rowMapper,activeStatus);
			
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		return list;
	}



	@Override
	public String login(CustomerUser user) {
		Customer c=null;
		String status="";
		try
		{
		String query="Select id,name,email,phone,active,birthdate from customer_scb where email=? and name=?";
		RowMapper<Customer> rowMapper=new CustomerRowMapper();
		c=template.queryForObject(query,rowMapper,user.getUsername(),user.getPassword());
	
		if(c==null)
		{
			status="User doesnt exist";
		}
		else
		{
		String userDB=c.getEmail();
		String userFE=user.getUsername();
		String passwordDB=c.getName();
		String passwordFE=user.getPassword();
		
		if(userDB.equals(userFE) && passwordDB.equals(passwordFE))
		{
			status="Login Success";
		}
		else
		{
			status="Invalid Credentials";
		}
		
		}
		
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
		return status;
		
	}

}
