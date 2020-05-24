package com.usermanager.services;

import com.usermanager.entity.User;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public interface UserService {

    User addUser(User user);

    User updateUser(int userId, User user);

    void deleteUser(int userId);

    User getUserById(int userId);

    List<User> getUsers();

    List<User> getUsersSortByAge();

    Set<User> getUsersSet();

    HashMap<String, User> getUsersHashMap();

}
