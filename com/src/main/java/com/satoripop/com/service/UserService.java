package com.satoripop.com.service;

import com.satoripop.com.model.User;
import com.satoripop.com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(
                user -> {
                    users.add(user);
                }

        );
        return users;
    }

    public void addUser(User user){
        userRepository.save(user);
    }
    public void update(User user, long id){
        userRepository.save(user);
    }

    public User getUserById(long id){
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
