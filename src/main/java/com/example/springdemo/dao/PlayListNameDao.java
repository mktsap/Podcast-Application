package com.example.springdemo.dao;

import java.util.List;

import com.example.springdemo.entity.PlayListName;

public interface PlayListNameDao {

	public int create(PlayListName playname, int id);

	public List<PlayListName> get(int id);

	public List show(int id);

}
