package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdemo.dao.CustomerDao;
import com.example.springdemo.entity.Customer;

//it will now handle transaction
@Service
public class CustomerServiceImpl implements CustomerService {
//	inject customerdao
@Autowired
private CustomerDao customerdao;
	
	@Transactional
	public List<Customer> getCustomer() {
		
		// TODO Auto-generated method stub
//		delegates the call to customerdao to get customer result
		return customerdao.getCustomer();
	}
	@Transactional
	public void saveCustomer(Customer thecustomer) {
		customerdao.savecustomer(thecustomer);
		// TODO Auto-generated method stub
		
	}
	@Transactional
	public void deleteCustomer(int theId) {
		customerdao.deletetheId(theId);
		// TODO Auto-generated method stub
		
	}
	@Transactional
	public Customer getCustomerbyId(int theId) {
		// TODO Auto-generated method stub
		return customerdao.getCustomerBy(theId);
	}
	@Transactional
	public List<Customer> searchCustomer(String searchname) {
		// TODO Auto-generated method stub
		return customerdao.searchcustomer(searchname);
	}

}
