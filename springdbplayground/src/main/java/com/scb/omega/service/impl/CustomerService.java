package com.scb.omega.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.omega.dao.ICustomerDAO;
import com.scb.omega.entities.Customer;
import com.scb.omega.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService
{
	@Autowired
	ICustomerDAO customerDao;
	
	@Override
	public String addCustomer(Customer c) {
		
		String result=customerDao.addCustomer(c);
		return result;
	}

	@Override
	public String updateCustomer(Customer c, int id) {
		String result=customerDao.updateCustomer(c, id);
		return result;
	}

	@Override
	public String deleteCustomer(int id) {
		String result=customerDao.deleteCustomer(id);
		return result;
	}

	@Override
	public Customer getCustomerById(int id) {
		
		return null;
	}

	@Override
	public List<Customer> getAllCustomers() {
	
		return null;
	}
	

}
