package com.example.springdemo.service;

import java.util.List;

import com.example.springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomer();

	public void saveCustomer(Customer thecustomer);

	public void deleteCustomer(int theId);

	public Customer getCustomerbyId(int theId);

	public List<Customer> searchCustomer(String searchname);
	

}
