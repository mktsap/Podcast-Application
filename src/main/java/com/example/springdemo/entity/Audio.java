package com.example.springdemo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="audio")
public class Audio {
	
	public Audio()
	{
		
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Lob
	@Column(name="audioname")
	private byte[] audio;

	@Column(name="filename")
	String fileName;
	
//	@Column(name="author_id")
//	private int author_id;
	
	@ManyToOne(cascade={CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	@JoinColumn(name="author_id")
	private Author author;
	
	private boolean status=false;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("calling setter");
		this.id = id;
	}

	public byte[] getAudio() {
		return audio;
	}

	public void setAudio(byte[] audio) {
		System.out.println("calling setter");
		this.audio = audio;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		System.out.println("calling setter");
		this.fileName = fileName;
	}

//	public int getAuthor_id() {
//		return author_id;
//	}
//
//	public void setAuthor_id(int author_id) {
//		this.author_id = author_id;
//	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
