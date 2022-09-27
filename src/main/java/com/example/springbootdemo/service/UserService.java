package com.example.springbootdemo.service;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.repository.UserRepository;

import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface UserService {

    User findById(Long id);
     List<User> findAll() ;

    void deleteById(Long id);
     List<User> getAllUsers();
     User saveUser(User user);

}
