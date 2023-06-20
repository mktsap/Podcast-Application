package com.example.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdemo.dao.PlayDetailsDao;

@Service
public class PlayDetailServiceImpl implements PlayDetailService {

	@Autowired
	PlayDetailsDao dao;
	
	@Transactional
	public void add(String detailname, int id,String name) {
		dao.add(detailname,id,name);
		// TODO Auto-generated method stub
		
	}

}
