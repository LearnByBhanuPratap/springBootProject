package com.bhanu.webservice.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhanu.webservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Serializable>{

}
