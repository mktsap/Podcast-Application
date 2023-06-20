package com.example.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springdemo.entity.Author;
import com.example.springdemo.entity.PlayListDetails;
import com.example.springdemo.entity.PlayListName;

@Repository
public class PlayListNameDaoImpl implements PlayListNameDao {

	@Autowired
	private SessionFactory sessionFactory;
	public int create(PlayListName playname, int id) {
		Session session=sessionFactory.getCurrentSession();
		Author author=(Author)session.get(Author.class, id);
		
		author.addPlaylistnames(playname);
		int pid=(Integer) session.save(playname);
		return pid;
		// TODO Auto-generated method stub
		
	}
	
	public List<PlayListName> get(int id) {
		
		Session session=sessionFactory.getCurrentSession();
		Author author=(Author)session.get(Author.class, id);
		List<PlayListName> list=author.getPlaylistnames();
		// TODO Auto-generated method stub
		return list;
	}

	public List show(int id) {
		Session session=sessionFactory.getCurrentSession();
		PlayListName playlist=session.get(PlayListName.class, id);
		List<PlayListDetails> details=playlist.getPlaylistdetails();
		System.out.println(details);
		return details;
	}

}
