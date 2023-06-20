package com.example.springdemo.dao;

import java.util.List;

import com.example.springdemo.entity.Audio;

public interface AudioDao {
	public void saveAudion(Audio audio,int id);
	
	public List<Audio> searchAudio(String name);
	
	public List<Audio> pending();

	public void approve(int id);

	public void decline(int id);

	public List<Audio> getAudio(String playname);

	public List<Audio> getAudios(String playname);

}
