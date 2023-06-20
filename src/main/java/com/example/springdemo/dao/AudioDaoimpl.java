package com.example.springdemo.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springdemo.entity.Audio;
import com.example.springdemo.entity.Author;

@Repository
public class AudioDaoimpl implements AudioDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void saveAudion(Audio audio,int id)
	{
		Session session=sessionFactory.getCurrentSession();
		
		
		Author author=(Author)session.get(Author.class, id);
//		Query<Author> query=session.createQuery("from Author where name=:"+name);
//		query.setParameter("name", name);
//		List<Author> list=query.getResultList();
//		(Author a:list)
//		{
//			
//		}
//		System.out.println(author);
		author.add(audio);
		
		session.save(audio);
		
		// TODO Auto-generated method stub

	}

	public List<Audio> searchAudio(String name) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query thequery=null;
		if(name!=null && name.trim().length()>0)
		{
			thequery=session.createQuery("from Audio where lower(fileName) like :name and status=:status");
			
			thequery.setParameter("name", "%" + name + "%");
			thequery.setParameter("status",true);
		}
		else
		{
			thequery=session.createQuery("from Audio",Audio.class);
		}
		List<Audio> list=thequery.getResultList();
		
		// TODO Auto-generated method stub
		return list;
	}

	public List<Audio> pending() {
		Session session=sessionFactory.getCurrentSession();
		Query<Audio> query=session.createQuery("select i from Audio i where i.status=:status");
		query.setParameter("status", false);
		List<Audio> pendinglist=query.getResultList();
		// TODO Auto-generated method stub
		return pendinglist;
	}

	public void approve(int id) {
		Session session=sessionFactory.getCurrentSession();
		Audio audio=session.get(Audio.class,id);
		audio.setStatus(true);
		// TODO Auto-generated method stub
		
	}

	public void decline(int id) {
		Session session=sessionFactory.getCurrentSession();
		Audio audio=session.get(Audio.class,id);
		session.delete(audio);
		// TODO Auto-generated method stub
		
	}

	public List<Audio> getAudio(String playname) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query<Audio> query=session.createQuery("select i from Audio i where i.fileName=:name");
		query.setParameter("name", playname);
		List<Audio> audiolist=query.getResultList();
		for(Audio a:audiolist)
		{
			byte barr[]=a.getAudio();
			FileOutputStream fout;
			try {
				
				fout = new FileOutputStream("E:\\jsp and servlet\\servlet\\SpringmvcandHibernate2\\src\\main\\webapp\\WEB-INF\\resources\\audio\\"+a.getFileName());
				fout.write(barr); 
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			 
		}
		return audiolist;
	}
	public List<Audio> getAudios(String playname) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Query<Audio> query=session.createQuery("select i from Audio i where i.fileName=:name");
		query.setParameter("name", playname);
		List<Audio> audiolist=query.getResultList();
		for(Audio a:audiolist)
		{
			byte barr[]=a.getAudio();
			FileOutputStream fout;
			try {
				
				fout = new FileOutputStream("E:\\jsp and servlet\\servlet\\SpringmvcandHibernate2\\src\\main\\webapp\\WEB-INF\\resources\\audios\\"+a.getFileName());
				fout.write(barr); 
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			 
		}
		return audiolist;
	}
	

}
