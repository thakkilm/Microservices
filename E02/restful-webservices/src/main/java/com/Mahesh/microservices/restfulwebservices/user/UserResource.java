package com.Mahesh.microservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {


    private UseeDaoService service;

    public UserResource(UseeDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return  service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user=service.findByUserId(id);
        if(user==null){
            throw new UserNotFoundException("id:"+id);

        }
     return  user;
    }

    @DeleteMapping ("/users/{id}")
    public void deleteUser(@PathVariable int id){
      service.deleteByUserId(id);

    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
       User savedUser= service.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
