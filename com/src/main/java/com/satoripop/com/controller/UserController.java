package com.satoripop.com.controller;

import com.satoripop.com.model.User;
import com.satoripop.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @RequestMapping("/user")
    public User getUser(){
        User user = new User(1L,"login","Oussama","Haddad","ousa@jhg.c",true);
        return user;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/user/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value="/user/{id}")
    public void deleteUser(@PathVariable long id){
        userService.deleteUser(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User User){
        userService.addUser(User);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
    public void updateUser(@RequestBody User user,@PathVariable long id){
        userService.update(user,id);
    }
}
