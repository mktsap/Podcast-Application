package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdemo.dao.Authordao;
import com.example.springdemo.entity.Audio;
import com.example.springdemo.entity.Author;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	Authordao authordao;
	
	@Transactional
	public int saveAuthor(Author author)
	{
		int id=authordao.saveAuthor(author);
		return id;
	}
	@Transactional
	public boolean login(String name) {
		
		// TODO Auto-generated method stub
		return authordao.login(name);
	}
	@Transactional
	public List<Author> logins(String name) {
		// TODO Auto-generated method stub
		return authordao.logins(name);
	}
	
	

}
