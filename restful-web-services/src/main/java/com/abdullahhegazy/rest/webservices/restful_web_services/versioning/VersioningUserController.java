package com.abdullahhegazy.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningUserController {

    @GetMapping(path = "/v1/user")
    public UserV1 getFirstVersionOfUser() {
	  return new UserV1("Abdullah Hegazy");
    }
    
    @GetMapping(path = "/v2/user")
    public UserV2 getSecondVersionOfUser() {
	  return new UserV2(new Name("Abdullah", "Hegazy"));
    }
    
    @GetMapping(path = "/user", params = "version=1")
    public UserV1 getFirstVersionOfUserRequestParam() {
	  return new UserV1("Abdullah Hegazy");
    }
    
    @GetMapping(path = "/user", params = "version=2")
    public UserV2 getSecondVersionOfUserRequestParam() {
	  return new UserV2(new Name("Abdullah", "Hegazy"));
    }
    
    @GetMapping(path = "/user/header", headers = "X-API-VERSION=1")
    public UserV1 getFirstVersionOfUserRequestHeader() {
	  return new UserV1("Abdullah Hegazy");
    }
    
    @GetMapping(path = "/user/header", headers = "X-API-VERSION=2")
    public UserV2 getSecondVersionOfUserRequestHeader() {
	  return new UserV2(new Name("Abdullah", "Hegazy"));
    }
    
    @GetMapping(path = "/user/accept-header", produces = "application/vnd.company.app-v1+json")
    public UserV1 getFirstVersionOfUserAcceptHeader() {
	  return new UserV1("Abdullah Hegazy");
    }
    
    @GetMapping(path = "/user/accept-header", produces = "application/vnd.company.app-v2+json")
    public UserV2 getSecondVersionOfUserAcceptHeader() {
	  return new UserV2(new Name("Abdullah", "Hegazy"));
    }
    
}
