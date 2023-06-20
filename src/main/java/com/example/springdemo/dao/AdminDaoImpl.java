package com.example.springdemo.dao;

import java.util.List;

import org.hibernate.query.Query;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.springdemo.entity.Admin;


@Repository
public class AdminDaoImpl implements AdminDao
{
	@Autowired
	private SessionFactory sessionFactory;
	public boolean Login(String name)
	{
		Session session =sessionFactory.getCurrentSession();
		Query<Admin> theQuery = 
				session.createQuery("select i from Admin i "+"where i.name=:name ");
		theQuery.setParameter("name", name);
		List<Admin> list=theQuery.getResultList();
		//		List<Admin> list1=session.createQuery("select i from Admin i "+"where i.name=:name  ").getResultList();
		
//		Admin admin=session.get(Admin.class, 1);
//		System.out.println(admin);
		if(list.size()!=0)
			return true;
		else
			return false;
	}

}
