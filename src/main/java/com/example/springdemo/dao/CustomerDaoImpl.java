package com.example.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import com.example.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao  {

	
//	Need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
//	add transactionla annotation
//	@Transactional
	public List<Customer> getCustomer()
	{
//		get hibernate session
		Session session=sessionFactory.getCurrentSession();
		
		
		Query<Customer> theQuery = 
				session.createQuery("from Customer");
//		create query
		List<Customer> customerlist=theQuery.getResultList();
		List<Customer> list=theQuery.list();
		
//		execute the query
		
//		return the resultlist
		// TODO Auto-generated method stub
//		return customerlist;
		return list;
	}

	public void savecustomer(Customer thecustomer) {
		Session session=sessionFactory.getCurrentSession();
		
//		saving or update the customer to database
//		session.save(thecustomer);
		
		session.saveOrUpdate(thecustomer);
		
		// TODO Auto-generated method stub
		
	}

	public void deletetheId(int theId) {
		Session session=sessionFactory.getCurrentSession();
//		Query<Customer> query=session.createQuery("delete from Customer where id=:customerId ",Customer.class);
//		query.setParameter("customerId", theId);
//		query.executeUpdate();
		Customer cust=session.get(Customer.class, theId);
		session.delete(cust);
		// TODO Auto-generated method stub
		
	}

	public Customer getCustomerBy(int theId) {
		Session session=sessionFactory.getCurrentSession();
		
//		get the Customer from Database
		Customer theCustomer=session.get(Customer.class, theId);
		// TODO Auto-generated method stub
		return theCustomer;
	}

	public List<Customer> searchcustomer(String searchname) {
		
		// TODO Auto-generated method stub
Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		//
		// only search by name if theSearchName is not empty
		//
		if (searchname != null && searchname.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			theQuery =currentSession.createQuery("from Customer where lower(first_name) like :theName or lower(last_name) like :theName", Customer.class);
			theQuery.setParameter("theName", "%" + searchname.toLowerCase() + "%");

		}
		else {
			// theSearchName is empty ... so just get all customers
			theQuery =currentSession.createQuery("from Customer", Customer.class);			
		}
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
					return customers;
	}

}
