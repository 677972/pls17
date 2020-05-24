package com.usermanager.services;

import com.usermanager.entity.User;
import com.usermanager.exceptions.UserNotFoundException;
import com.usermanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int userId, User user) {
        user.setUserid(userId);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User getUserById(int userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if (!optionalUser.isPresent())
            throw new UserNotFoundException("Пользователь не найден");
        return optionalUser.get();
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersSortByAge() {
        List list = new ArrayList(userRepository.findAll());
        Collections.sort(list, UserServiceImpl.getUserByAge());
        return list;
    }

    public static Comparator<User> getUserByAge() {
        Comparator<User> comp = new Comparator<User>() {
            @Override
            public int compare(User s1, User s2) {
                return s1.getUserAge().compareTo(s2.getUserAge());
            }
        };
        return comp;
    }

    @Override
    public Set<User> getUsersSet() {
        return userRepository.findAllByUserFirstNameOrderByUserAgeDesc("Stas");
    }

    @Override
    public HashMap<String, User> getUsersHashMap() {
        HashMap result = new HashMap();
        result.put("Users",userRepository.findAll());
        return result;
    };

}
