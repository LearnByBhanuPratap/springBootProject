package com.bhanu.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bhanu.webservice.entity.Post;

public interface PostInfoRepository extends JpaRepository<Post, String>{

}
