package com.example.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springdemo.entity.Admin;
import com.example.springdemo.entity.Audio;
import com.example.springdemo.entity.Author;
import com.example.springdemo.entity.PlayList;

@Repository
public class PlayListDaoImpl implements PlayListDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void save(int id,int theid) 
	{
		
		Session session=sessionFactory.getCurrentSession();
		Audio audio=session.get(Audio.class, id);
		String name=audio.getFileName();
//		System.out.println(name);
		PlayList playlist=new PlayList();
		playlist.setPlaylistname(name);
		Author author=session.get(Author.class, theid);
//		System.out.println(author.getFirst_name());
		
		playlist.setAuthor(author);
//		author.setPlaylist(playlist);
		session.save(playlist);
		
		// TODO Auto-generated method stub

	}

	public List<PlayList> getPlayList(int theid) {
		Session session=sessionFactory.getCurrentSession();
		Author author=session.get(Author.class, theid);
		
//		Query<PlayList> theQuery = 
//				session.createQuery("select i.playlistname from PlayList i inner join i.");
//		theQuery.setParameter("author_id", theid);
		List<PlayList> list=author.getPlaylists();
		System.out.println(list);
		// TODO Auto-generated method stub
		return list;
	}

}
