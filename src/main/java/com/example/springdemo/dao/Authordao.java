package com.example.springdemo.dao;

import java.util.List;

import com.example.springdemo.entity.Author;

public interface Authordao {
	public int saveAuthor(Author author);

	public boolean login(String name);
	public List<Author> logins(String name);
	
	
}
