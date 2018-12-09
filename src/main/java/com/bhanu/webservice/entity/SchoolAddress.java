package com.bhanu.webservice.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "SCHOOLADDRESS")
@Table(name = "SCHOOLADDRESS")
public class SchoolAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String schoolName;

	private String postalcode;

	private String state;

	public KidsInfo getKidsinfo() {
		return kidsinfo;
	}

	public void setKidsinfo(KidsInfo kidsinfo) {
		this.kidsinfo = kidsinfo;
	}

	private String city;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "kidsinfo_id", nullable = false)
	@JsonBackReference
	private KidsInfo kidsinfo;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
