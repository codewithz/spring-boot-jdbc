package com.scb.omega.dao;

import java.util.List;

import com.scb.omega.entities.Customer;
import com.scb.omega.entities.vo.CustomerUser;

public interface ICustomerDAO {
	
	public String addCustomer(Customer c);
	public String updateCustomer(Customer c,int id);
	public String deleteCustomer(int id);
	public Customer getCustomerById(int id);
	public List<Customer> getAllCustomers();
	public List<Customer> getCustomersByActive(boolean activeStatus);
	public String login(CustomerUser user);
	public Customer getCustomerByEmail(String email);
}
