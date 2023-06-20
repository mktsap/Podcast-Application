package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdemo.dao.PlayListNameDao;
import com.example.springdemo.entity.PlayListName;

@Service
public class PlayListNameServiceImpl implements PlayListNameService {

	@Autowired
	PlayListNameDao playlistdao;
	@Transactional
	public int createplay(PlayListName playname, int id) {
		int pid=playlistdao.create(playname,id);
		return pid;
		// TODO Auto-generated method stub
		
	}
	@Transactional
	public List<PlayListName> getplay(int id) {
		// TODO Auto-generated method stub
		return playlistdao.get(id);
	}
	@Transactional
	public List show(int id) {
		return playlistdao.show(id);
		
		// TODO Auto-generated method stub
		
	}

}
