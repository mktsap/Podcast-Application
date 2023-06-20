package com.example.springdemo.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.springdemo.entity.Audio;
import com.example.springdemo.entity.Author;
import com.example.springdemo.entity.PlayList;
import com.example.springdemo.entity.PlayListDetails;
import com.example.springdemo.entity.PlayListName;
import com.example.springdemo.service.AudioService;
import com.example.springdemo.service.AuthorService;
import com.example.springdemo.service.PlayDetailService;
import com.example.springdemo.service.PlayListNameService;
import com.example.springdemo.service.PlayListService;

@Controller
@RequestMapping("/author")

public class AuthorController 
{
	int id;
    List<Author> authorobj;
    
    List<PlayListName> playlists;
	@Autowired
	private AuthorService authorservice;
	
	@Value("#{countryOptions}") 
	 private Map<String, String> countryOptions;
	@Autowired
	private AudioService audioservice;
	@Autowired
	PlayListService playlistservice;
	
	@Autowired
	PlayListNameService playlistnameservice;
	
	@Autowired
	PlayDetailService playlistdetailservice;
	
	@GetMapping("/authorForm")
	public String authorForm(Model themodel)
	{
		Author author=new Author();
		themodel.addAttribute("author",author);
		themodel.addAttribute("thecountryOptions", countryOptions);
		
		return "author-form";
	}
	@PostMapping("/saveAuthor")
	public String showForms(@ModelAttribute("author")Author author,Model theModel)
	{
		id=authorservice.saveAuthor(author);
		System.out.println(id);
		return "redirect:../customer/homes";
	}
	
	@GetMapping("/loginforauthor")
	public String loginforAuthor(Model themodel)
	{
		Author author=new Author();
		themodel.addAttribute("author",author);
		
		return "author/author-login";
	}
	@PostMapping("/Authorlogins")
	public String authorLogin(HttpSession session ,@ModelAttribute("author") Author author,@RequestParam("username")String name,Model themodel)
	{
//		HttpSession session=request.getSession();
		
		
//		String name=author.getUsername();
//		Author authors=new Author();
		themodel.addAttribute("author",author);
//		String user_name=author.getUsername();
//		session.setAttribute("author", author);
		
		boolean flag=authorservice.login(name);
		authorobj=authorservice.logins(name);
		themodel.addAttribute("authorobj",authorobj);
		for(Author obj:authorobj)
			System.out.println(obj.getFirst_name());
		if(flag)
			return "author/author-landpage";
		else
			return "homes";
	}
	@GetMapping("/upload")
	public String upload(@ModelAttribute("author") Author author,Model themodel)
	{
//		int id;
//		for(Author obj:authorobj)
//			{
//				id=obj.getId();
//				System.out.println(id);
//			}

		Audio audio=new Audio();
		themodel.addAttribute("audio",audio);
		return "author/upload";
	}
	@PostMapping("/uploadFile")
	public String saveFile( HttpServletRequest servletRequest,@RequestParam("fileUpload") CommonsMultipartFile fileUpload,@ModelAttribute("audio")Audio audios)
	{
//		Author author=(Author) session.getAttribute("author");
//		System.out.println(author.getUsername());
		
//		 if (fileUpload != null && fileUpload.length > 0) {
//	            for (CommonsMultipartFile aFile : fileUpload){
		int id=0;
		for(Author obj:authorobj)
			id=obj.getId();
//		System.out.println(authorobj);
		
	                System.out.println("Saving file: " + fileUpload.getOriginalFilename());
	                 
	                Audio uploadFile = new Audio();
//	                System.out.println(audios.getId());
//	                uploadFile.setFileName((fileUpload.getOriginalFilename().replaceAll("[a-zA-z]*", "Audio1")));
	                uploadFile.setFileName(fileUpload.getOriginalFilename());
	                uploadFile.setAudio(fileUpload.getBytes());
	                String fileName=fileUpload.getOriginalFilename();
//	                File imageFiles = new File(servletRequest.getServletContext().getRealPath("WEB-INF"), "image");
//	                System.out.println(servletRequest.getServletContext().getRealPath("WEB-INF"));
//	                imageFiles.mkdirs();
//	                File imageFile = new File(imageFiles, fileName);
//	                try
//	                {
//	                	System.out.println(imageFile.createNewFile());
//	                     fileUpload.transferTo(imageFile);
//	                	
//	                }
//	                catch(Exception e)
//	                {
//	                	e.printStackTrace();
//	                }
//	                fileUpload.transferTo();
	                audioservice.saveAudio(uploadFile,id);
	                
//	            }
//	        }
		
		return "author/successupload";	
	}

	@RequestMapping("/playlist")
	public String addtoPlaylist(HttpSession session,@RequestParam("audioId")int theid,Model themodel)
	{
		int id=0;
		for(Author obj:authorobj)
			id=obj.getId();
		
		playlistservice.save(theid,id);
		Author author=new Author();
		
		themodel.addAttribute("author",author);
		return "author/playlistsuccess";
	}
	@RequestMapping("/viewPlaylist")
	public String viewPlayList(HttpSession session,@RequestParam("authorId") int theid,Model themodel)
	{
		
		
		List<PlayList> playlists=playlistservice.getPlayList(theid);
		themodel.addAttribute("playlist", playlists);
		
		return "author/playlist";
	}
	@GetMapping("/play")
	public String playAudio(@RequestParam("playname")String playname,Model themodel)
	{
		List<Audio> audio=audioservice.getAudio(playname);
		themodel.addAttribute("audiolist",audio);
		return "author/play";
	}
	List<Audio> audioduplicate;
	@PostMapping("/searchAudio")
	public String searchAudio(@RequestParam("audioName")String thename,Model themodel)
	{
		
		List<PlayListName> playlistnames=playlists;
		for(PlayListName play:playlistnames)
			System.out.println(play.getPlaylistname());
		
		List<Audio> audioList=audioservice.searchAudio(thename);
		audioduplicate=audioservice.searchAudio(thename);
		themodel.addAttribute("audio",audioList);
		themodel.addAttribute("playlists", playlistnames);
		return "audio/audio-list";
	}
	
	@GetMapping("/createPlaylist")
	public String createPlaylist(Model themodel)
	{
		PlayListName playlistname=new PlayListName();
		themodel.addAttribute("playlistname", playlistname);
		return "author/playlistcreate";
	}
	@RequestMapping("/createPlaylists")
	public String createPlaylists(@ModelAttribute("playlistname")PlayListName playname,Model themodel)
	{
		int id=0;
		for(Author obj:authorobj)
			id=obj.getId();
		playlistnameservice.createplay(playname,id);
		PlayListName playlistname=new PlayListName();
		themodel.addAttribute("playlistname", playlistname);
		return "author/playlistsuccess";
	}
	@RequestMapping("/viewPlaylists")
	public String viewPlaylists(@RequestParam("authorId")int id,Model themodel)
	{
		
	    playlists=playlistnameservice.getplay(id);
//		PlayListName playlistname=new PlayListName();
		themodel.addAttribute("playlists", playlists);
		return "author/showplaylist";
	}
		
//	adding to specific playlist
	@RequestMapping("/playlistdetails")
	public String playListdetails(@RequestParam("detailid") String detailname)
	{
		String name="";
		for(Audio a:audioduplicate)
			name=a.getFileName();
//		System.out.println(name);
		int id=0;
		
		for(Author obj:authorobj)
			id=obj.getId();
		playlistdetailservice.add(detailname,id,name);
		return "author/playlistsuccess";
	}
	@RequestMapping("/showdetail")
	public String showdetails(@RequestParam("showid")int id,Model themodel)
	{
		List<PlayListDetails> detailslist=playlistnameservice.show(id);
		themodel.addAttribute("playlistdetails",detailslist);
		return "author/playlist2";
	}

	@GetMapping("/play2")
	public String playAudios(@RequestParam("playnames")String playname,Model themodel)
	{
		List<Audio> audio=audioservice.getAudios(playname);
		themodel.addAttribute("audiolist",audio);
		return "author/play";
	}

}
