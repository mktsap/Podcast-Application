package com.example.springdemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="playlistnames")
public class PlayListName 
{
	public PlayListName()
	{
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="playlistname")
	String playlistname;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="author_id")
	private Author author;
	
	@OneToMany(mappedBy="playlistname")
	private List<PlayListDetails> playlistdetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaylistname() {
		return playlistname;
	}

	public void setPlaylistname(String playlistname) {
		this.playlistname = playlistname;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<PlayListDetails> getPlaylistdetails() {
		return playlistdetails;
	}

	public void setPlaylistdetails(List<PlayListDetails> playlistdetails) {
		this.playlistdetails = playlistdetails;
	}
	public void add(PlayListDetails playdetails)
	{
		if(playlistdetails==null)
			playlistdetails=new ArrayList();
		playlistdetails.add(playdetails);
		playdetails.setPlaylistname(this);
	}
	
}
