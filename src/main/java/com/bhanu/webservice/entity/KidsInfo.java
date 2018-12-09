package com.bhanu.webservice.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "KIDSINFO")
@Table(name = "KIDSINFO")
public class KidsInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String age;

	private String schoolName;

	private String sex;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userdetails_id", nullable = false)
	@JsonBackReference
	private UserDetails userdetails;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "kidsinfo")
	@JsonManagedReference
	private SchoolAddress schoolAddress;

	public UserDetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}

	public SchoolAddress getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(SchoolAddress schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public KidsInfo(){
		
	}
	
	public KidsInfo(String name, String age, String schoolName, String sex, UserDetails userdetails) {
		super();
		this.name = name;
		this.age = age;
		this.schoolName = schoolName;
		this.sex = sex;
		this.userdetails = userdetails;
	}

}
