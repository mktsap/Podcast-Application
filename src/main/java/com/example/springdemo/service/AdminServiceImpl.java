package com.example.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdemo.dao.AdminDao;
//import com.example.springdemo.dao.AdminDaoImpl;

@Service
public class AdminServiceImpl implements AdminService 
{
	@Autowired
	AdminDao admindao;
	
	@Transactional
	public boolean login(String name) 
	{
		
		return admindao.Login(name);
	}

}
