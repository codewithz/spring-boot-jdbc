package com.scb.omega;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.scb.omega.entities.Calculator;


public class CalculatorTest 
{
	Calculator underTest;
	
	@BeforeEach
	public void setUp()
	{
		System.out.println("Before Each Invoked");
		underTest=new Calculator();
	}
	
	@AfterEach
	public void tearDown()
	{
		System.out.println("After Each Invoked");
		underTest=null;
	}
	
	@Test
	public void canAdd() 
	{
		System.out.println("Testing In Progress");
		//Given
			int numberOne=20;
			int numberTwo=30;
		//When
			int result=underTest.add(numberOne, numberTwo);
		//Then
			int expected=50;
			assertEquals(expected, result);
			//assertThat(result).isEqualTo(expected);
		
	}

}
