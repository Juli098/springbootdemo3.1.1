package com.example.springbootdemo.service;

import com.example.springbootdemo.model.User;


public interface UserService {

    User save(User user);
    void delete(Long id);
    User oneUser(Long id);

    Iterable<User> getAllUsers();


}
