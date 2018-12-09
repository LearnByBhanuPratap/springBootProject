package com.bhanu.webservice.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bhanu.webservice.entity.Post;

@Transactional
@Repository
public class PostInfoDAO {
	
	
	@Autowired
	PostInfoRepository postInfoRepository;
	
	public void insertPost(Post post){
		try {
			postInfoRepository.save(post);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Post> getAllPost(){
		try {
			List<Post> allPost = postInfoRepository.findAll();
			return allPost;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
