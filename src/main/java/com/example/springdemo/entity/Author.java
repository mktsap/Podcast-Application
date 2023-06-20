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
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="authors")
public class Author 
{
	public Author()
	{
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="username")
	private String username;
	
	@Column(name="country")
	private String country;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy="author",cascade={CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
	private List<Audio> audios;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="playlist_id")
//	private PlayList playlist;
	
//	@OneToOne(mappedBy="author",cascade={CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE},fetch = FetchType.LAZY)
//	private PlayList playlist;
//	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="author_id")
	private List<PlayList> playlists;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="author_id")
	private List<PlayListName> playlistnames;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Audio> getAudios() {
		return audios;
	}
	public void setAudios(List<Audio> audios) {
		this.audios = audios;
	}
	
//add convient method for bidirectional relationship
	
	public void add(Audio tempaudio)
	{
		if(audios==null)
			audios=new ArrayList();
		audios.add(tempaudio);
		
//		bidirectional
//		same as instructor one
		tempaudio.setAuthor(this);
	}
//	
//	
	
	public List<PlayList> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(List<PlayList> playlists) {
		this.playlists = playlists;
	}
	public void addPlaylist(PlayList playlist)
	{
		if(playlists==null)
		{
			playlists=new ArrayList();
		}
		playlists.add(playlist);
		
	}
	public void addPlaylistnames(PlayListName playlist)
	{
		if(playlistnames==null)
		{
			playlistnames=new ArrayList();
		}
		playlistnames.add(playlist);
		
	}
	public List<PlayListName> getPlaylistnames() {
		return playlistnames;
	}
	public void setPlaylistnames(List<PlayListName> playlistnames) {
		this.playlistnames = playlistnames;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", username=" + username + ", country=" + country + ", password=" + password + ", audios=" + audios
				+ ", playlists=" + playlists + ", playlistnames=" + playlistnames + "]";
	}

}
