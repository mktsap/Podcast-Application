package com.example.springdemo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springdemo.entity.Customer;
import com.example.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    
//	inject DAO into this controller
	
	@Autowired
//	private CustomerDao customerdao;
	private CustomerService customerservice;
	@RequestMapping("/homes")
	public String getForm()
	{
		return "homes";
	}
	
	
//	@RequestMapping("/list")
	@GetMapping("/list")
	public String getCustomer(Model themodel)
	{
		List<Customer> customers=customerservice.getCustomer();
		
//		add the customer to SpringMVC Model
		themodel.addAttribute("customer", customers);
		return "customer-list";
	}
	
	
	
}
