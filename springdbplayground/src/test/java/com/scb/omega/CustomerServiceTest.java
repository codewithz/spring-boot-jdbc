package com.scb.omega;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.scb.omega.dao.impl.CustomerDAO;
import com.scb.omega.entities.Customer;
import com.scb.omega.service.impl.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest 
{
	@InjectMocks
	CustomerService underTest;
	
	@Mock
	CustomerDAO dao;
	
	
	@Test
	public void canGetAllCustomers()
	{
		//Given
			List<Customer> expected=new ArrayList<>();
			Customer c1=new Customer(1001, "Tom", "tom@gmail.com", 9879871234l, true, LocalDate.now());
			Customer c2=new Customer(1002, "Alex", "alex@yahoo.com", 9879871235l, false, LocalDate.now());
			expected.add(c1);
			expected.add(c2);
		//When
			when(dao.getAllCustomers()).thenReturn(expected);
			
			List<Customer> actual=underTest.getAllCustomers();
		//Then
			assertEquals(2,actual.size());
			verify(dao,times(1)).getAllCustomers();
			assertThat(actual).isEqualTo(expected);
			
	}
}
