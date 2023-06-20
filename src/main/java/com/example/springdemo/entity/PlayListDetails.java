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
@Table(name="playlistdetails")
public class PlayListDetails {
	

	public PlayListDetails() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="filename")
	private String filename;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="playlistname_id")
	private PlayListName playlistname;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public PlayListName getPlaylistname() {
		return playlistname;
	}

	public void setPlaylistname(PlayListName playlistname) {
		this.playlistname = playlistname;
	}

	@Override
	public String toString() {
		return "PlayListDetails [id=" + id + ", filename=" + filename + ", playlistname=" + playlistname + "]";
	}
	
	
	
}
