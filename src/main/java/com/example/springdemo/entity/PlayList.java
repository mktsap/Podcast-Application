package com.example.springdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="playlist")
public class PlayList {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="playlistname")
	private String playlistname;
	

//	@OneToOne(mappedBy="playlist",cascade=CascadeType.ALL)
//	private Author author;
	
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="author_id")
	private Author author;
	
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

//	public Author getAuthor() {
//		return author;
//	}
////
//	public void setAuthor(Author author) {
//		this.author = author;
//	}
	
	
}
