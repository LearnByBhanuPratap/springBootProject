package com.bhanu.webservice.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhanu.webservice.dao.EmployeeDAO;
import com.bhanu.webservice.dao.PostInfoDAO;
import com.bhanu.webservice.dao.UserDAO;
import com.bhanu.webservice.entity.Employee;
import com.bhanu.webservice.entity.Employee_Address;
import com.bhanu.webservice.entity.Post;
import com.bhanu.webservice.entity.User;

@Service
public class DeploymentRestServiceImpl implements DeploymentRestService{
	Logger logger = Logger.getLogger(DeploymentRestServiceImpl.class.getName());
	
	@Autowired
	private PostInfoDAO  postInfoDAO;
	
	@Autowired
	private UserDAO  userDAO;
	
	@Autowired
	private EmployeeDAO  employeeDAO;


	@Override
	public void insertPost(Post post) {
		postInfoDAO.insertPost(post);
		
	}


	@Override
	public List<Post> getAllPost() {
		return postInfoDAO.getAllPost();
	}


	@Override
	public void insertUser(User user) {
		userDAO.insertUser(user);
		
	}


	@Override
	public List<User> getUser() {
		return userDAO.getUser();
	}
	
	@Override
	public void deleteUser(long id) throws Exception {
		User user = userDAO.findUser(id);
		userDAO.deleteUser(user);
	}



	@Override
	public void insertEmployee(Employee employee) {
		employeeDAO.insertEmployee(employee);
		
	}


	@Override
	public List<Employee_Address> getEmployee() {
		return employeeDAO.getEmployee();
	}
	
	@Override
	public void deleteEmployee(String empId) {
		employeeDAO.deleteEmployee(empId);
	}

}
