package com.jobTracker.jobTracker.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

//This class is actually a bigger thing then we thought it is an  DTO
// DATA TRANSFER OBJECT - That carry the data between layers
// It is just a simple class that holds data
// No database connection, no annotations, no logic
// just field + getters + setters
// this UserForm class is already a DTO - we just didnt call it that 

public class UserForm {
 @NotBlank(message="Name is Required")	
 private String name;
 @NotBlank(message="Email is Required")
 @Email(message="Email Should be Valid")
 private String email;
 @Pattern(regexp = "^[0-9]{10,15}$", message = "Phone number must be 10-15 digits")
 private String phone;
 @Size(max = 500, message = "Description cannot exceed 500 characters")
 private String description;
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
 
 
 
 
}
