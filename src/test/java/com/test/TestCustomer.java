package com.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;

import com.cg.go.entity.Address;
import com.cg.go.entity.Customer;
import com.cg.go.service.CustomerServiceImpl;
import com.cg.go.service.ICustomerService;
import com.cg.go.util.JpaUtil;

public class TestCustomer {
	
	ICustomerService customerService=new CustomerServiceImpl();
	
	@Test
	public void testAddCustomer() {

		Address address=new Address(11,6,"bankcolony", "wgl", "wgl","Telangana",506002);
		Customer customerEntity=new Customer(10,"naresh","8179563708","thon@gmail.com",address,"retailer");
		Customer customer=customerService.addCustomer(customerEntity);
		Assertions.assertEquals(10,customer.getCustomerId());
		Assertions.assertEquals("naresh",customer.getCustomerName());
		Assertions.assertEquals("8179563708",customer.getMobileNo());
		Assertions.assertEquals("thon@gmail.com",customer.getEmail());
		Assertions.assertEquals(address,customer.getAddress());
		Assertions.assertEquals("retailer",customer.getRole());
		
	}
	
	
	@Test
	public void testUpdateCustomer() {
		
		Address address=new Address(11,6,"bankcolony", "wgl", "wgl","Telangana",506002);
		Customer customerEntity=new Customer(10,"naresh","8179563708","thon@gmail.com",address,"retailer");
		Customer customer=customerService.addCustomer(customerEntity);
		customerEntity.setCustomerName("Suresh");
		customerEntity.setRole("Sales Representive");
		customer=customerService.updateCustomer(customerEntity);
		Assertions.assertEquals(10,customer.getCustomerId());
		Assertions.assertEquals("Suresh",customer.getCustomerName());
		Assertions.assertEquals("Sales Representive",customer.getRole());
		
	}
	
	
	@Test
	public void testGetAllCustomers() {
		
		List<Customer> customerList=new ArrayList<Customer>();
		Address address=new Address(11,6,"bankcolony", "wgl", "wgl","Telangana",506002);
		Customer firstCustomer=new Customer(10,"naresh","8179563708","thon@gmail.com",address,"retailer");
		Customer secondCustomer=new Customer(11,"arvind","xxxxxxxxxx","arvi@gmail.com",address,"sales");
		customerList.add(customerService.addCustomer(firstCustomer));
		customerList.add(customerService.addCustomer(secondCustomer));

		Assertions.assertEquals(customerList,customerService.getAllCustomers());
		
	}
	
	
	@Test
	public void testViewCustomer() {
		
		Address address=new Address(11,6,"bankcolony", "wgl", "wgl","Telangana",506002);
		Customer customer=new Customer(10,"naresh","8179563708","thon@gmail.com",address,"retailer");
		customerService.addCustomer(customer);
		Assertions.assertEquals(customer,customerService.viewCustomer(customer));
		
	}
	
	
	@Test
	public void testRemoveCustomer() {
		
		Address address=new Address(11,6,"bankcolony", "wgl", "wgl","Telangana",506002);
		Customer customer=new Customer(10,"naresh","8179563708","thon@gmail.com",address,"retailer");
		customerService.addCustomer(customer);
		Assertions.assertEquals(null,customerService.removeCustomer(customer));	
	}
	 @AfterAll
	    static void close() {
	        JpaUtil util = JpaUtil.getInstance();
	        util.close();
	    }
}
