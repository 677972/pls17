package com.usermanager.services;

import com.usermanager.entity.User;
import com.usermanager.exceptions.UserNotFoundException;
import com.usermanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (!optionalUser.isPresent())
            throw new UserNotFoundException("Пользователь не найден");
        return optionalUser.get();
    }

    public User updateUser (int userId, User user){
        user.setUserid(userId);
        return userRepository.save(user);
    }

    public void deleteUser (int userId) {
        userRepository.deleteById(userId);
    }
}
