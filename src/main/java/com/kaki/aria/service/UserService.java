/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.service;

import com.kaki.aria.model.User;
import com.kaki.aria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author alfia
 */
@Service("userService")
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder bcCryptPasswordEncoder;
    
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public User saveUser(User user) {
        return userRepository.save(user);      
    }
    
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public User savePassword(User user) {
        user.setPassword(bcCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        return userRepository.save(user); 
    }
}
