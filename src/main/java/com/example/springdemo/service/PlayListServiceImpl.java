package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdemo.dao.PlayListDao;
import com.example.springdemo.entity.PlayList;

@Service
public class PlayListServiceImpl implements PlayListService {

	
	@Autowired
	PlayListDao playlistdao;
	
	@Transactional
	public void save(int id,int theid) {
		playlistdao.save(id,theid);
		// TODO Auto-generated method stub

	}
	
	@Transactional
	public List<PlayList> getPlayList(int theid) {
		// TODO Auto-generated method stub
		return playlistdao.getPlayList(theid);
	}

}
