package com.scb.omega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scb.omega.entities.vo.OrderCartVO;
import com.scb.omega.service.IOrderService;
import com.scb.omega.utils.Status;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController 
{
	@Autowired
	IOrderService orderService;
	
	@PostMapping("/placeOrder")
	public ResponseEntity<Object> storeOrder(@RequestBody OrderCartVO orderCartVO)
	{
		ResponseEntity<Object> response=null;
		
		String result=orderService.placeOrder(orderCartVO);
		
		if(result.equals(Status.SUCCESS))
		{
			response=new ResponseEntity<>(HttpStatus.CREATED);
		}
		else
		{
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
		
	}
	@GetMapping("/orderDetails/{id}")
	public ResponseEntity<OrderCartVO> getOrderDetails(@PathVariable int id)
	{
		ResponseEntity<OrderCartVO> response=null;
		
		OrderCartVO vo=orderService.getOrderById(id);
		
		if(vo!=null)
		{
			response=new ResponseEntity<>(vo,HttpStatus.OK);
		}
		else
		{
			response=new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
}
