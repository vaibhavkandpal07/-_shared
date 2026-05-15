package com.jobTracker.jobTracker.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;


@Entity
@Table(name="users")
public class User
{
	   
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private long id;
   
   @Column(name="name" , nullable=false ,length = 100)
   private String name;
   
   
   @Column(name = "email" , length= 150 , unique = true , nullable = false )
   private String email;
   
  
   @Column(name = "phone" , length = 10)
   private String phone;
   
  
   @Column(name = "description", length = 500)
   private String description;
   
   @Lob
   @Column(name = "resume", columnDefinition = "LONGBLOB")
   private byte[] resume;

   @Column(name = "file_name")
   private String fileName;

   @Column(name = "file_type")
   private String fileType;
   
   public User() {
   }
   public User(long id, String name, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

   public long getId() {
	return id;
   }


   public void setId(long id) {
	this.id = id;
   }


   public String getName() {
	return name;
   }


   public void setName(String name) {
	this.name = name;
   }


   public String getEmail() {
	return email;
   }


   public void setEmail(String email) {
	this.email = email;
   }


   public String getPhone() {
	return phone;
   }


   public void setPhone(String phone) {
	this.phone = phone;
   }

   
  
   public String getDescription() {
	return description;
   }

   public void setDescription(String description) {
	this.description = description;
   }
   
   @Override
   public String toString() {
	return "User [id=" + id + 
			", name=" + name + 
			", email=" + email + 
			", phone=" + phone + 
			", description=" + description + "]";
   }


   public byte[] getResume() {
	return resume;
   }


   public void setResume(byte[] resume) {
	this.resume = resume;
   }


   public String getFileName() {
	return fileName;
   }


   public void setFileName(String fileName) {
	this.fileName = fileName;
   }


   public String getFileType() {
	return fileType;
   }


   public void setFileType(String fileType) {
	this.fileType = fileType;
   }

	
}
/*
Since you already have UserForm with getters/setters, you don't need them in User entity — but actually you still do, because:

UserForm → captures form input (DTO)
User entity → Hibernate needs getters/setters to read/write column values to DB*/





