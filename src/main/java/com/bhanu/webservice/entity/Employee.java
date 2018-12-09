package com.bhanu.webservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="EMPLOYEE")
public class Employee
{
    @Id
    @Column(name="webs_request_id")
    private String empId;
    
    @Column(name="NAME")
    private String empName;

    @OneToOne(fetch = FetchType.LAZY, mappedBy="employee" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Employee_Address employeeAddress;

    public Employee()
    {
        super();
    }

    public Employee(String empId, String empName, Employee_Address employeeAddress)
    {
        super();
        this.empId = empId;
        this.empName = empName;
        this.employeeAddress = employeeAddress;
    }

    public String getEmpId()
    {
        return empId;
    }

    public void setEmpId(String empId)
    {
        this.empId = empId;
    }

    public String getEmpName()
    {
        return empName;
    }

    public void setEmpName(String empName)
    {
        this.empName = empName;
    }

    public Employee_Address getEmployeeAddress()
    {
        return employeeAddress;
    }

    public void setEmployeeAddress(Employee_Address employeeAddress)
    {
        this.employeeAddress = employeeAddress;
    }

    @Override
    public String toString()
    {
        return "Employee [empId=" + empId + ", empName=" + empName + ", employeeAddress=" + employeeAddress + "]";
    }
}