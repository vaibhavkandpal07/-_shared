package com.jobTracker.jobTracker.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jobTracker.jobTracker.DTO.UserForm;
import com.jobTracker.jobTracker.model.User;
import com.jobTracker.jobTracker.repository.UserRepository;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	
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
		public String HandleForm(@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult result, @RequestParam("resume") MultipartFile file, Model model)throws IOException 
		{
		
		//@valid  is mandatory to trigger validation and let the other annotation do their job 
		// BindingResult must be immediately comes after dto or @Valid
		
		if (result.hasErrors()) {
			return "add-job";
		}
		
		User user = new User();
		  
		
		    user.setName(userForm.getName());
	        user.setEmail(userForm.getEmail());
	        user.setPhone(userForm.getPhone());
	        user.setDescription(userForm.getDescription());
	        
	        user.setResume(file.getBytes());
	        user.setFileName( file.getOriginalFilename());
	        user.setFileType( file.getContentType());
	        
	        userRepository.save(user);
	        
	        model.addAttribute("userForm",userForm);	  
	        
	        
	        return "result";
	        
		}
	
	
		
	}
	
	
	
	
