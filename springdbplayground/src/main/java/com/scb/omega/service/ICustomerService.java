package com.scb.omega.service;

import java.util.List;

import com.scb.omega.entities.Customer;

public interface ICustomerService {
	
	public String addCustomer(Customer c);
	public String updateCustomer(Customer c,int id);
	public String deleteCustomer(int id);
	public Customer getCustomerById(int id);
	public List<Customer> getAllCustomers();

}
