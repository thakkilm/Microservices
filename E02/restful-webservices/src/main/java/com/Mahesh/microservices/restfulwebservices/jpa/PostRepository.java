package com.Mahesh.microservices.restfulwebservices.jpa;

import com.Mahesh.microservices.restfulwebservices.user.Post;
import com.Mahesh.microservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

}
