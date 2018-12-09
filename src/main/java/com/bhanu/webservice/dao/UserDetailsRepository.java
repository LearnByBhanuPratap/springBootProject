package com.bhanu.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhanu.webservice.entity.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

}
