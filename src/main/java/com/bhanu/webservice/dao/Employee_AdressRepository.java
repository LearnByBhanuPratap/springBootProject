package com.bhanu.webservice.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhanu.webservice.entity.Employee_Address;

public interface Employee_AdressRepository extends JpaRepository<Employee_Address, Serializable>{

}
