package com.bhanu.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bhanu.webservice.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	public User findById(long id);
	
	
	public void deleteById(long id);
	
	

}
