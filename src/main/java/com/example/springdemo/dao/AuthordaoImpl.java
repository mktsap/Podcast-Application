package com.example.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springdemo.entity.Admin;
import com.example.springdemo.entity.Author;

@Repository
public class AuthordaoImpl implements Authordao  
	
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public int saveAuthor(Author author) {
		Session session=sessionFactory.getCurrentSession();
		
//		saving or update the customer to database
		int id=(Integer) session.save(author);
		// TODO Auto-generated method stub
		return id;
	}
	public boolean login(String name) {
		Session session=sessionFactory.getCurrentSession();
		Query<Author> theQuery = 
				session.createQuery("select i from Author i "+"where i.username=:name ");
		theQuery.setParameter("name", name);
		List<Author> list=theQuery.getResultList();
		//		List<Admin> list1=session.createQuery("select i from Admin i "+"where i.name=:name  ").getResultList();
		
//		Admin admin=session.get(Admin.class, 1);
//		System.out.println(admin);
		if(list.size()!=0)
			return true;
		else
			return false;
		
	}
	public List<Author> logins(String name)
	{
		Session session=sessionFactory.getCurrentSession();
		Query<Author> theQuery = 
				session.createQuery("select i from Author i "+"where i.username=:name ");
		theQuery.setParameter("name", name);
		List<Author> list=theQuery.getResultList();
		return list;
	}

}
