package com.bhanu.webservice.service;

import java.util.List;

import com.bhanu.webservice.entity.Employee;
import com.bhanu.webservice.entity.Employee_Address;
import com.bhanu.webservice.entity.Post;
import com.bhanu.webservice.entity.User;

public interface DeploymentRestService {
	
	void insertPost(Post post);
	
	List<Post> getAllPost();
	
	void insertUser(User user);
	
	List<User> getUser();
	
	void insertEmployee(Employee user);
	
	List<Employee_Address> getEmployee();
	
	public void deleteUser(long id) throws Exception;
	
	public void deleteEmployee(String empId);

}
