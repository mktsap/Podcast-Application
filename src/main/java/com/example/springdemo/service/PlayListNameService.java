package com.example.springdemo.service;

import java.util.List;

import com.example.springdemo.entity.PlayListName;

public interface PlayListNameService {

	int createplay(PlayListName playname, int id);

	List<PlayListName> getplay(int id);

	List show(int id);

}
