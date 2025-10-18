package com.abdullahhegazy.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
    private UserDaoService userDaoService;
    
    public UserResource(UserDaoService userDaoService) {
	  this.userDaoService = userDaoService;
    }
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
	  return userDaoService.findAll();
    }
    
    @GetMapping("/users/{id}")
    public EntityModel<User> getOneUser(@PathVariable int id) {
	  User findOneUser = userDaoService.findOne(id);
	  if(findOneUser == null) {
		throw new UserNotFoundException("User with ID:"+ id + " Not Found.");
	  }
	  EntityModel<User> userEntityModel = EntityModel.of(findOneUser);
	  WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());
	  userEntityModel.add(link.withRel("all-users"));
	  return userEntityModel;
    }
    
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
	  userDaoService.deleteById(id);
    }
    
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
	  User savedUser = userDaoService.save(user);
	  URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
	  return ResponseEntity.created(location ).build();
	  
    }
}
