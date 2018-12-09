package com.bhanu.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhanu.webservice.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, String>{

}
