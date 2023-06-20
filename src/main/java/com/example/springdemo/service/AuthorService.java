package com.example.springdemo.service;

import java.util.List;

import com.example.springdemo.entity.Audio;
import com.example.springdemo.entity.Author;

public interface AuthorService {
	public int saveAuthor(Author author);

	public boolean login(String name);

	public List<Author> logins(String name);
	
	
}
