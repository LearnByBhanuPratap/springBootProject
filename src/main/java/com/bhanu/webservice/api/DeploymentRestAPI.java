package com.bhanu.webservice.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bhanu.webservice.entity.Employee;
import com.bhanu.webservice.entity.Employee_Address;
import com.bhanu.webservice.entity.Post;
import com.bhanu.webservice.entity.User;
import com.bhanu.webservice.service.DeploymentRestServiceImpl;

@RestController
@RequestMapping("/bhanuservice")
public class DeploymentRestAPI {
	
	@Autowired
	private DeploymentRestServiceImpl deploymentRestServiceImpl;


	@RequestMapping(value = "/insertPost", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> insertPost(@RequestBody Post post){
		deploymentRestServiceImpl.insertPost(post);
		return ResponseEntity.status(HttpStatus.OK).body("post created");
		
	}
	
	@RequestMapping(value = "/getPost", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Post>> getPost(){
		List<Post> data = deploymentRestServiceImpl.getAllPost();
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseEntity<String>>  insertUser(@RequestBody User user){
		
		deploymentRestServiceImpl.insertUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseEntity<String>("User created", HttpStatus.ACCEPTED));
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUser(){
		List<User> data = deploymentRestServiceImpl.getUser();
		return ResponseEntity.status(HttpStatus.OK).body(data);
	}
	
	@RequestMapping(value ="/user/{user_id}", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ResponseEntity<String>> deleteUser(@PathVariable Integer user_id){
		try {
			deploymentRestServiceImpl.deleteUser(user_id);
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseEntity<String>("User is created with id: "+user_id, HttpStatus.ACCEPTED));
		} catch (Exception e) {
			Map<String, String> error = new HashMap<String, String>();
			error.put("body", "User is not created with id: "+user_id);
			error.put("message", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseEntity<String>("User is not created with id: "+user_id+" and error Message is:-"+e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR));
		}
		
	}
}
