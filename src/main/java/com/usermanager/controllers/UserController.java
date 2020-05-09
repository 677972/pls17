package com.usermanager.controllers;

import com.usermanager.entity.User;
import com.usermanager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Service
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(value = "/{userId}")
    public User getUser(@PathVariable("userId") int userId) {
        return userService.getUser(userId);
    }

    @PutMapping(value = "/{userId}")
    public User updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);
    }
}
