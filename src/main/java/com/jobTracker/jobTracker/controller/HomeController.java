package com.jobTracker.jobTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) { // USING Model we take data from controller to view   
		model.addAttribute("message","Welcome to Job Tracker Application");
		return"home";
	}
	@GetMapping("/jobs")
	public String jobs() {
		return"jobs";
	}
	@GetMapping("/add-job")
	public String addjob(Model model) {
		model.addAttribute("userForm",new UserForm());
		return"add-job";
	}
	
	@PostMapping("/submitForm")
		public String HandleForm(@ModelAttribute UserForm userForm, @RequestParam("resume") MultipartFile file, Model model)
		{
		    System.out.println("Name: " + userForm.getName());
	        System.out.println("Email: " + userForm.getEmail());
	        System.out.println("Phone: " + userForm.getPhone());
	        System.out.println("Description: " + userForm.getDescription());
	        
	        System.out.println("File Name: " + file.getOriginalFilename());
	        System.out.println("File Size: " + file.getSize());
	        System.out.println("File Type: " + file.getContentType());
	        
	        model.addAttribute("UserForm",userForm);	  
	        
	        return "result";
	        
		}
	
	
		
	}
	
	
	
	
