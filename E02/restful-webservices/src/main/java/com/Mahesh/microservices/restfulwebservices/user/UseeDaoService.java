package com.Mahesh.microservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UseeDaoService {
    private static List<User> users=new ArrayList<>();
    private static int userCount=0;
    static {
        users.add(new User(++userCount,"Mahesh", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Lokesh", LocalDate.now().minusYears(31)));
        users.add(new User(++userCount,"Chaitu", LocalDate.now().minusYears(29)));
    }
 public List<User>findAll(){

        return users;
 }
 public User findByUserId(int id){
     Predicate<? super User> predicate=user->user.getId().equals(id);
     return users.stream().filter(predicate).findFirst().orElse(null);
//        return users.get(id);
 }

    public void deleteByUserId(int id){
        Predicate<? super User> predicate=user->user.getId().equals(id);
       users.removeIf(predicate);
//        return users.get(id);
    }
 public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
 }
}
