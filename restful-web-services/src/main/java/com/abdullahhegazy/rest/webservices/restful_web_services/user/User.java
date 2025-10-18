package com.abdullahhegazy.rest.webservices.restful_web_services.user;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {

    @JsonProperty("user_id")
    private Integer id;
    @JsonProperty("user_name")
    @Size(min = 3, message = "Name should be 2 characters or more")
    private String name;
    @JsonProperty("birth_date")
    @Past(message = "Birth date should be in the past")
    private LocalDate birthDate;
    public User(Integer id, String name, LocalDate birthDate) {
	  super();
	  this.id = id;
	  this.name = name;
	  this.birthDate = birthDate;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    @Override
    public String toString() {
	  return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
    }
    
    
}
