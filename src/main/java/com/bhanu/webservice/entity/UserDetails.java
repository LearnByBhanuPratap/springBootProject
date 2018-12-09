package com.bhanu.webservice.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "USERDETAILS")
@Table(name = "USERDETAILS")
public class UserDetails  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String country;

	private String state;

	private String higherEducation;

	private String jobPost;

	private Boolean isMarried;

	private Boolean hasKids;

	private int howmanyKids;

	private Boolean isKidsMarried;

	private Date userCreatedOn;

	private Date userModifiedOn;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userdetails")
	@JsonManagedReference
	private KidsInfo kidsInfo;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getHigherEducation() {
		return higherEducation;
	}

	public void setHigherEducation(String higherEducation) {
		this.higherEducation = higherEducation;
	}

	public String getJobPost() {
		return jobPost;
	}

	public void setJobPost(String jobPost) {
		this.jobPost = jobPost;
	}

	public Boolean getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(Boolean isMarried) {
		this.isMarried = isMarried;
	}

	public Boolean getHasKids() {
		return hasKids;
	}

	public void setHasKids(Boolean hasKids) {
		this.hasKids = hasKids;
	}

	public int getHowmanyKids() {
		return howmanyKids;
	}

	public void setHowmanyKids(int howmanyKids) {
		this.howmanyKids = howmanyKids;
	}

	public Boolean getIsKidsMarried() {
		return isKidsMarried;
	}

	public void setIsKidsMarried(Boolean isKidsMarried) {
		this.isKidsMarried = isKidsMarried;
	}

	public Date getUserCreatedOn() {

		return userCreatedOn;
	}

	@PrePersist
	public void setCreationDateAndLastModifiedOnPersist() throws ParseException {
		Timestamp timestamp = new Timestamp(new Date().getTime());

		SimpleDateFormat form = new SimpleDateFormat("YYYY-MM-dd");

		this.userModifiedOn = form.parse(timestamp.toString());
		this.userCreatedOn = form.parse(timestamp.toString());
	}

	@PreUpdate
	public void setLastModifiedOnUpdate() throws ParseException {
		Timestamp timestamp = new Timestamp(new Date().getTime());

		SimpleDateFormat form = new SimpleDateFormat("YYYY-MM-dd");
		this.userModifiedOn = form.parse(timestamp.toString());
	}

	public Date getUserModifiedOn() throws ParseException {
		SimpleDateFormat form = new SimpleDateFormat("YYYY-MM-dd");
		//this.userModifiedOn = form.parse(timestamp.toString());
		return userModifiedOn = form.parse(userModifiedOn.toString());
	}

	public KidsInfo getKidsInfo() {
		return kidsInfo;
	}

	public void setKidsInfo(KidsInfo kidsInfo) {
		this.kidsInfo = kidsInfo;
	}
	
	public UserDetails(){
		
	}
	
	public UserDetails(String name, String country, String state, String higherEducation, String jobPost, Boolean isMarried, Boolean hasKids, int howmanyKids, Boolean isKidsMarried, Date userCreatedOn, Date userModifiedOn) {
		super();
		this.name = name;
		this.country = country;
		this.state = state;
		this.higherEducation = higherEducation;
		this.jobPost = jobPost;
		this.isMarried = isMarried;
		this.hasKids = hasKids;
		this.howmanyKids = howmanyKids;
		this.isKidsMarried = isKidsMarried;
		this.userCreatedOn = userCreatedOn;
		this.userModifiedOn = userModifiedOn;
	}


}