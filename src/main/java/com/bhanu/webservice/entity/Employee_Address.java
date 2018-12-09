package com.bhanu.webservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="EMPLOYEE_ADDRESS")
public class Employee_Address
{
    @Id
    @Column(name="webs_request_id")
    private String addrId;
    
    @Column(name="STREET")
    private String street;
    @Column(name="CITY")
    private String city;
    @Column(name="STATE")
    private String state;
    @Column(name="COUNTRY")
    private String country;
    
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_empId")
    @JsonBackReference
    private Employee employee;

    public Employee_Address()
    {
        super();
    }

    public Employee_Address(String addrId, String street, String city, String state, String country, Employee employee)
    {
        super();
        this.addrId = addrId;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.employee = employee;
    }

    public String getAddrId()
    {
        return addrId;
    }

    public void setAddrId(String addrId)
    {
        this.addrId = addrId;
    }

    public String getStreet()
    {
        return street;
    }

    public void setStreet(String street)
    {
        this.street = street;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
}
