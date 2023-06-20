package com.example.springdemo.service;

import java.util.List;

import com.example.springdemo.entity.PlayList;

public interface PlayListService {
	public void save(int id,int theid);

	public List<PlayList> getPlayList(int theid);
}
