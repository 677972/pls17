package com.usermanager.repository;

import com.usermanager.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    List<User> findAll();

    Set<User> findAllByUserFirstNameOrderByUserAgeDesc(String UserFirstName);

}

