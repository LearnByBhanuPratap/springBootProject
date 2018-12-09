package com.bhanu.webservice.dao;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhanu.webservice.entity.Employee;
import com.bhanu.webservice.entity.Employee_Address;

@Transactional
@Repository
public class EmployeeDAO {
	

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	Employee_AdressRepository employee_AdressRepository;
	
	
	public void insertEmployee(Employee employee){
		try {
			
			String id = UUID.randomUUID().toString();
			employee.setEmpId(id);
			
			
			Employee_Address empAddress = employee.getEmployeeAddress();
			
			empAddress.setAddrId(id);
			
			empAddress.setEmployee(employee);
			
			employee.setEmployeeAddress(empAddress);

			employeeRepository.save(employee);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Employee_Address> getEmployee(){
		try {
			// Get list of all Employee & Employee Address
			List<Employee_Address> empAddress = employee_AdressRepository.findAll();
			
			
		      // Displaying the Employee details
	        for (Employee_Address employeeAddress : empAddress)
	        {
	        	   System.out.println("*** Employee Details ***");

	               Employee employee = employeeAddress.getEmployee();
	              // System.out.println("Employee Id   : " + employee.getWebs_request_id());
	               System.out.println("Employee Name : " + employee.getEmpName());

	               System.out.println("*** Employee Address Details ***");
	               System.out.println("Street  : " + employeeAddress.getStreet());
	               System.out.println("City    : " + employeeAddress.getCity());
	               System.out.println("State   : " + employeeAddress.getState());
	               System.out.println("Country : " + employeeAddress.getCountry());
	        }
	        
	        return empAddress;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
