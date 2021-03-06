package com.scb.omega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.scb.omega.entities.Customer;
import com.scb.omega.entities.vo.CustomerUser;
import com.scb.omega.service.ICustomerService;
import com.scb.omega.utils.Status;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController 
{
	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity addCustomer(@RequestBody Customer c)
	{
		ResponseEntity response=null;
		String result=customerService.addCustomer(c);
			
		if(result.equals(Status.SUCCESS))
		{
			
			response=new ResponseEntity<>(HttpStatus.CREATED);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer was not created");
		}
		return response;
	}
	
	@PutMapping("/customer/{id}")
	public ResponseEntity<Object> updateCustomer(@RequestBody Customer c,@PathVariable int id)
	{
		ResponseEntity<Object> response=null;
		String result=customerService.updateCustomer(c, id);
		if(result.equals(Status.SUCCESS))
		{
			response=new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with id:"+id+" was not found | Update Operation Failed");
		}
		return response;
		
	}
	
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Object> deleteCustomer(@PathVariable int id)
	{
		ResponseEntity<Object> response=null;
		String result=customerService.deleteCustomer(id);
		if(result.equals(Status.SUCCESS))
		{
			response=new ResponseEntity<>(HttpStatus.OK);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with id:"+id+" was not found | Delete Operation Failed");
		}
		return response;
		
		
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable int id)
	{
		ResponseEntity<Customer> response=null;
		
		Customer c=customerService.getCustomerById(id);
		
		if(c!=null)
		{
			response=new ResponseEntity<>(c,HttpStatus.OK);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with id:"+id+" was not found");
		}
		return response;
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers()
	{
		ResponseEntity<List<Customer>> response=null;
		List<Customer> list=customerService.getAllCustomers();
		if(list.size()>0)
		{
			response=new ResponseEntity<>(list,HttpStatus.OK);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No customers available");
		}
		return response;
	}
	
	@GetMapping("/customers/{active}")
	public ResponseEntity<List<Customer>> getCustomersByActive(@PathVariable boolean active)
	{
		ResponseEntity<List<Customer>> response=null;
		List<Customer> list=customerService.getCustomersByActive(active);
		if(list.size()>0)
		{
			response=new ResponseEntity<>(list,HttpStatus.OK);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with active status of:"+active+" was not found");
		}
		return response;
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody CustomerUser user)
	{
		ResponseEntity<String> response=null;
		String status=customerService.login(user);
		if(status.equals("Login Success"))
		{
			response=new ResponseEntity<>(status,HttpStatus.OK);
		}
		else if(status.equals("Invalid Credentials")) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Credentials");
		
			
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found");
		}
		
		return response;
		
	}
}
