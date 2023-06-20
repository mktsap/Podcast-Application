package com.example.springdemo.dao;

import java.util.List;

import com.example.springdemo.entity.PlayList;

public interface PlayListDao {
	public void save(int id,int theid);

	public List<PlayList> getPlayList(int theid);

}
