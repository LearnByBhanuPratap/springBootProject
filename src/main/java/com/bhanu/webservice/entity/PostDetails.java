package com.bhanu.webservice.entity;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity(name = "POSTDETAILS")
@Table(name = "POST_DETAILS")
public class PostDetails implements Serializable{
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue
    private Long id;


	@Column(name = "created_on")
    private Date createdOn;


	@Column(name = "created_by")
    private Timestamp createdBy;
 
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
 
    public PostDetails() {}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@PrePersist
	public void setCreationDateAndLastModifiedOnPersist()  {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		this.createdBy = timestamp;
		this.createdOn = timestamp;
	}

	@PreUpdate
	public void setLastModifiedOnUpdate() {
		Timestamp timestamp = new Timestamp(new Date().getTime());
		this.createdOn = timestamp;
	}

}