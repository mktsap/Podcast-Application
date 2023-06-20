package com.example.springdemo.dao;

import java.util.List;

import com.example.springdemo.entity.Customer;



public interface CustomerDao {
	public List<Customer> getCustomer();

	public void savecustomer(Customer thecustomer);

	public void deletetheId(int theId);

	public Customer getCustomerBy(int theId);

	public List<Customer> searchcustomer(String searchname);
	
}
