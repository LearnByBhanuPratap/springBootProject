package com.bhanu.webservice.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "POST")
@Table(name = "POST")
public class Post implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long id;
    
	@Column(name = "title", nullable = false)
    private String title;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, 
              fetch = FetchType.LAZY, optional = false)
    private PostDetails details;
  

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PostDetails getDetails() {
		return details;
	}

	public void setDetails(PostDetails details) {
		this.details = details;
	}

}