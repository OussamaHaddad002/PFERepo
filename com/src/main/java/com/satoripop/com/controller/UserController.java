package com.satoripop.com.controller;

import com.satoripop.com.model.User;
import com.satoripop.com.repository.UserRepository;
import com.satoripop.com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
public class UserController {


    @Autowired
    private UserService userService;
    private UserRepository userRepository;

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
        User existingUser = userService.getUserById(id);
        if (existingUser != null) {
            // Update the properties of the existing user with the values from the request
            if (user.getLogin() != null) {
                existingUser.setLogin(user.getLogin());
            }
            if (user.getPassword() != null) {
                existingUser.setPassword(user.getPassword());
            }
            if (user.getFirstName() != null) {
                existingUser.setFirstName(user.getFirstName());
            }
            if (user.getLastName() != null) {
                existingUser.setLastName(user.getLastName());
            }
            if (user.getEmail() != null) {
                existingUser.setEmail(user.getEmail());
            }
            if (user.isActivated() != true) {
                existingUser.setActivated(user.isActivated());
            }
            if (user.getActivationKey() != null) {
                existingUser.setActivationKey(user.getActivationKey());
            }
            if (user.getResetKey() != null) {
                existingUser.setResetKey(user.getResetKey());
            }
            if (user.getResetDate() != 0) {
                existingUser.setResetDate(user.getResetDate());
            }

            // Call the update method from the service to save the changes
            userService.update(existingUser,id);
        }
    }

    @GetMapping
    public User getUserByLogin(@RequestParam String login) throws ChangeSetPersister.NotFoundException {
        User user = userRepository.findByLogin(login);

        if (user == null) {
            throw new ChangeSetPersister.NotFoundException();
        }

        return user;
    }
}
