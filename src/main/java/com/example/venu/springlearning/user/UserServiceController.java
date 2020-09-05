/**
 * 
 */
package com.example.venu.springlearning.user;

//import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.venu.springlearning.exception.UserNotFoundException;

/**
 * @author venugopal
 *
 */
@RestController
public class UserServiceController {
	
	@Autowired
	private UserDAOService service;

	@GetMapping("/users")
	public List<User> getAllUsers(){
		return service.findAll();
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User newUser = service.createUser(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/users/{id}")
	public Resource<User> getUser(@PathVariable int id) {
		User user = service.getUser(id);
		
		if (user == null) {
			throw new UserNotFoundException("id-"+id+" not present");
		}
		
		Resource<User> resource = new Resource<User>(user);
		
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteUser(id);
		
		if (user == null) {
			throw new UserNotFoundException("id-"+id+" not present");
		}
	}
}
