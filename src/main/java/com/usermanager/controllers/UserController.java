package com.usermanager.controllers;

import com.usermanager.entity.User;
import com.usermanager.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/users")
@Service
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userServiceImpl.addUser(user);
    }

    @PutMapping(value = "/{userId}")
    public User updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
        return userServiceImpl.updateUser(userId, user);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userServiceImpl.deleteUser(userId);
    }

    @GetMapping(value = "/{userId}")
    public User getUserById(@PathVariable("userId") int userId) {
        return userServiceImpl.getUserById(userId);
    }

    @GetMapping
    public List<User> getUsers() {
        return userServiceImpl.getUsers();
    }

    @GetMapping ("/Sort")
    public List<User> getUsersSort() {
        return userServiceImpl.getUsersSortByAge();
    }

    @GetMapping ("/Set")
    public Set<User> getUsersSet() {return userServiceImpl.getUsersSet();}

    @GetMapping ("/HashMap")
    public HashMap<String, User> getUsersHashMap() {return userServiceImpl.getUsersHashMap();}

    @GetMapping ("/StreamSortAgeAsc")
    public List<User> getUsersStreamSortAge() {return userServiceImpl.getUsersStreamSortAgeAsc();}

    @GetMapping ("/StreamFilterFirstName")
    public List<User> getUsersStreamFilterFirstName() {return userServiceImpl.getUsersStreamFilterFirstName();}

    @GetMapping(value = "/StreamFilterByFirstName/{userFirstName}")
    public List<User> StreamFilterByFirstName(@PathVariable("userFirstName") String userFirstName) {
        return userServiceImpl.StreamFilterByFirstName(userFirstName);
    }

}
