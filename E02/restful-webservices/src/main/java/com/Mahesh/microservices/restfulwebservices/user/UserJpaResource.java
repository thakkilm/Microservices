package com.Mahesh.microservices.restfulwebservices.user;

import com.Mahesh.microservices.restfulwebservices.jpa.PostRepository;
import com.Mahesh.microservices.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {


    private PostRepository postRepository;
    private UserRepository userRepository;

    public UserJpaResource(PostRepository postRepository,UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository=userRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return  userRepository.findAll();
    }

//    @GetMapping("/users/{id}")
//    public User retrieveUser(@PathVariable int id){
//        User user=service.findByUserId(id);
//        if(user==null){
//            throw new UserNotFoundException("id:"+id);
//        }
//     return  user;
//    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }
        EntityModel<User> entityModel=EntityModel.of(user.get());
        WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return  entityModel;
    }

    @DeleteMapping ("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @GetMapping ("/jpa/users/{id}/posts")
    public List<Post> retrievePosts(@PathVariable int id){

        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }
       return user.get().getPosts();
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
       User savedUser= userRepository.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping ("/jpa/users/{id}/posts")
    public ResponseEntity<Object> savePosts(@PathVariable int id, @Valid @RequestBody Post post){

        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty()){
            throw new UserNotFoundException("id:"+id);
        }
        post.setUser(user.get());
        Post savedPost=postRepository.save(post);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}")
                .buildAndExpand(savedPost.getId()).toUri();
        return ResponseEntity.created(location).build();
//        return user.get().getPosts();
    }

}
