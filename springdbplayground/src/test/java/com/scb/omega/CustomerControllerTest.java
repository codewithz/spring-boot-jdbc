package com.scb.omega;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.scb.omega.controller.CustomerController;
import com.scb.omega.entities.Customer;
import com.scb.omega.service.impl.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest 
{
	@InjectMocks
	CustomerController underTest;
	
	@Mock
	CustomerService service;
	
	@Test
	public void canCustomerGetById()
	{
		//Given
			int id=1001;
			Customer expected=new Customer(1001,"Martha","martha@gmail.com", 9898987654l, true, LocalDate.now());
		//When
			when(service.getCustomerById(id)).thenReturn(expected);
			
			ResponseEntity<Customer> response=underTest.getCustomerById(id);
		//Then
			Customer actual=response.getBody();
			assertEquals(expected, actual);
			
		
	}
	
}
