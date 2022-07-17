package com.ats.controller;
import com.ats.entities.User;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users/")
public class UsersController {

    List<User> allUsers = new ArrayList<>();

    @GetMapping("getAllUsers")
    public List<User> getAllUsers(){
        return allUsers;
    }

    @GetMapping("getUser/{id}")
    public User getUser(@PathVariable int id){
        User user = allUsers.stream().filter(x->x.getUserId()==id).findAny().orElse(null);
        return user;
    }

    @PostMapping("create")
    public String createNewUser(@RequestBody User userData){
        allUsers.add(userData);
        return "User Created Successfully!! wohoo";
    }

    @DeleteMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable int id){
        User user = allUsers.stream().filter(x->x.getUserId()==id).findAny().orElse(null);
        allUsers.remove(user);
        return "User deleted successfully !!!";
    }


}
