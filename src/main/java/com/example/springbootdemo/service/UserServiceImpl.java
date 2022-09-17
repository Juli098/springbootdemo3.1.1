package com.example.springbootdemo.service;

import com.example.springbootdemo.model.User;

import com.example.springbootdemo.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;



@Component
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional(readOnly = true)
    public User oneUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User save(User user) {
       return userRepository.save(user);

    }


    @Override
    @Transactional(readOnly = true)
    public void delete(Long id) {
        userRepository.deleteById(id);

    }


}