package com.bhanu.webservice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhanu.webservice.entity.User;
import com.bhanu.webservice.entity.UserProfile;

@Transactional
@Repository
public class UserDAO {
	

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	@Autowired
	EntityManager entityManager;
	
	public void insertUser(User user){
		try {
			 // Set child reference(userProfile) in parent entity(user)
	        user.setUserProfile(user.getUserProfile());

	        // Set parent reference(user) in child entity(userProfile)
	        user.getUserProfile().setUser(user);

	        // Save Parent Reference (which will save the child as well)
	        userRepository.save(user);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<User> getUser(){
		try {
			List<User> userProfile = userRepository.findAll();
			
			return userProfile;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public User findUser(long id){
		User user = userRepository.findById(id);
		return user;
	}
	
	public void deleteUser(User user) throws Exception{
		userRepository.delete(user);
	}

}
