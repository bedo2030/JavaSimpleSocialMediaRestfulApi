package com.abdullahhegazy.rest.webservices.restful_web_services.versioning;

public class UserV1 {

    private String name;

    public UserV1(String name) {
	  this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
	  return "UserV1 [name=" + name + "]";
    }
    
}
