package com.example.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springdemo.dao.AudioDao;
import com.example.springdemo.entity.Audio;

@Service
public class AudioServiceImpl implements AudioService {

	@Autowired
	AudioDao audiodao;

	@Transactional
	public void saveAudio(Audio audio,int id) {
		audiodao.saveAudion(audio,id);
		
		
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	public List<Audio> searchAudio(String name) {
		// TODO Auto-generated method stub
		return audiodao.searchAudio(name);
	}
	@Transactional
	public List<Audio> pending() {
		// TODO Auto-generated method stub
		return audiodao.pending();
	}
	@Transactional
	public void approve(int id) {
		audiodao.approve(id);
		// TODO Auto-generated method stub
		
	}
	@Transactional
	public void decline(int id) {
		audiodao.decline(id);
		// TODO Auto-generated method stub
		
	}
	@Transactional
	public List<Audio> getAudio(String playname) {
		// TODO Auto-generated method stub
		return audiodao.getAudio(playname);
	}
	@Transactional
	public List<Audio> getAudios(String playname) {
		// TODO Auto-generated method stub
		return audiodao.getAudios(playname);
	}

}
