package com.example.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springdemo.entity.Audio;
import com.example.springdemo.entity.Author;
import com.example.springdemo.entity.PlayListDetails;
import com.example.springdemo.entity.PlayListName;

@Repository
public class PlayDetailsImpl implements PlayDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void add(String detailname, int id,String names) {
		System.out.println(detailname+" "+id+" "+names);
		Session session=sessionFactory.getCurrentSession();
		Author author=session.get(Author.class	, id);
		List<Audio> audio=author.getAudios();
		List<PlayListName> playname=author.getPlaylistnames();
		PlayListDetails details=new PlayListDetails();
//		String name="";
//		for(Audio a:audio)
//		{
//			name=a.getFileName();
////			System.out.println(names+".."+name);
////			System.out.println(name.equals(names));
//			if(name.equals(names))
//				details.setFilename(name);
//			
//		}
		details.setFilename(names);
		for(PlayListName n:playname)
			details.setPlaylistname(n);
		
		session.save(details);
		
		// TODO Auto-generated method stub
		
	}

}
