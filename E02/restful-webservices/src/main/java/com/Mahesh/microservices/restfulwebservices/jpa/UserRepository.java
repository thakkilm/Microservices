package com.Mahesh.microservices.restfulwebservices.jpa;

import com.Mahesh.microservices.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
