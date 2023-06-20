package com.example.springdemo.controller;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.example.springdemo.entity.Admin;
import com.example.springdemo.entity.Audio;
import com.example.springdemo.entity.Author;
import com.example.springdemo.entity.Customer;
import com.example.springdemo.service.AdminService;
import com.example.springdemo.service.AudioService;
import com.example.springdemo.service.AuthorService;
import com.example.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController 
{
    
//	inject DAO into this controller
	
//	 @Value("#{countryOptions}") 
//	 private Map<String, String> countryOptions;
	 
	@Autowired
	private AdminService adminservice;
	
	@Autowired
//	private CustomerDao customerdao;
	private CustomerService customerservice;
	
	@Autowired
	private AuthorService authorservice;
	
	@Autowired
	private AudioService audioservice;
	
	@RequestMapping("/homes")
	public String getForm()
	{
		return "homes";
	}
	
	@RequestMapping("/login")
	public String login(Model themodel)
	{
		Admin admin=new Admin();
		themodel.addAttribute("admin",admin);
		return "admin-login";
	}
	@RequestMapping("/logins")
	public String showData(@ModelAttribute("admin")Admin theadmin)
	{
		String name=theadmin.getName();
		boolean flag=adminservice.login(name);
		if(flag)
			return "admin-showForm";
		else
			return "admin-login";
					
	}
	
//	@RequestMapping("/list")
	@GetMapping("/list")
	public String getCustomer(Model themodel)
	{
		List<Customer> customers=customerservice.getCustomer();
		
//		add the customer to SpringMVC Model
		themodel.addAttribute("customer", customers);
		return "customer-list";
	}
	@RequestMapping("/pending")
	public String pendingshow(Model themodel)
	{
		List<Audio> pendinglist=audioservice.pending();
		themodel.addAttribute("pending", pendinglist);
		return "pending";
	}
	@RequestMapping("/approve")
	public String approve(@RequestParam("audioId")int id,Model themodel)
	{
		audioservice.decline(id);
		return "redirect:/customer/pending";
	}
	@RequestMapping("/decline")
	public String decline(@RequestParam("audioId")int id,Model themodel)
	{
		audioservice.approve(id);
		return "redirect:/customer/logins";
	}
	
	@GetMapping("/showFormForAdd")
	public String showForm(Model theModel)
	{
//		create new model to bind the data
		Customer cust=new Customer();
		theModel.addAttribute("customer",cust);
		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String showData(@ModelAttribute("customer")Customer thecustomer)
	{
//		Save the customer to database
		customerservice.saveCustomer(thecustomer);
//		redirect to customerlist
		return "redirect:/customer/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId)
	{
		customerservice.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/customerform")
	public String customerForm(Model themodel)
	{
		Customer cust=new Customer();
		themodel.addAttribute("customer",cust);
		return "customer-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateForm(@RequestParam("customerId") int theId,Model theModel)
	{
//		get the customer from service
		Customer thecustomer=customerservice.getCustomerbyId(theId);
		
//		set customer as model attribute to prepopulate the form
		theModel.addAttribute("customer", thecustomer);
//		send over to our form
		
		
		return "customer-form";
	}
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String searchname,Model themodel)
	{
//		search customer from service
		List<Customer> customer=customerservice.searchCustomer(searchname);
		themodel.addAttribute("customer",customer);
		
		return "customer-list";
	}
	

	
//	@GetMapping("/authorForm")
//	public String authorForm(Model themodel)
//	{
//		Author author=new Author();
//		themodel.addAttribute("author",author);
//		themodel.addAttribute("thecountryOptions", countryOptions);
//		
//		return "author-form";
//	}
//	@PostMapping("/saveAuthor")
//	public String showForms(@ModelAttribute("author")Author author,Model theModel)
//	{
//		int id=authorservice.saveAuthor(author);
//		System.out.println(id);
//		return "redirect:/customer/homes";
//	}
	
//	@GetMapping("/upload")
//	public String upload(Model themodel)
//	{
//		Audio audio=new Audio();
//		themodel.addAttribute("audio",audio);
//		return "upload";
//	}
//	@PostMapping("/uploadFile")
//	public String saveFile(@RequestParam("fileUpload") CommonsMultipartFile fileUpload)
//	{
////		 if (fileUpload != null && fileUpload.length > 0) {
////	            for (CommonsMultipartFile aFile : fileUpload){
//	                  
//	                System.out.println("Saving file: " + fileUpload.getOriginalFilename());
//	                 
//	                Audio uploadFile = new Audio();
//	                
////	                uploadFile.setFileName((fileUpload.getOriginalFilename().replaceAll("[a-zA-z]*", "Audio1")));
//	                uploadFile.setFileName(fileUpload.getOriginalFilename());
//	                uploadFile.setAudio(fileUpload.getBytes());
//	                audioservice.saveAudio(uploadFile);          
////	            }
////	        }
//		
//		return "author/author-landpage";	
//	}
//	@PostMapping("/searchAudio")
//	public String searchAudio(@RequestParam("audioName")String thename,Model themodel)
//	{
//		List<Audio> audioList=audioservice.searchAudio(thename);
//		themodel.addAttribute("audio",audioList);
//		return "audio/audio-list";
//	}
	
	
}
