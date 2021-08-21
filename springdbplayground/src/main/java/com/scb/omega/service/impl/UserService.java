package com.scb.omega.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.scb.omega.entities.Customer;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
    CustomerService service;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

    	Customer c=service.getCustomerByEmail(userName);
     
        return new User(c.getEmail(),c.getName(),new ArrayList<>());
    }
}