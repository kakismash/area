/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.service;

import com.kaki.aria.model.Role;
import com.kaki.aria.model.User;
import com.kaki.aria.repository.RoleRepository;
import com.kaki.aria.repository.UserRepository;
import java.util.Arrays;
import java.util.HashSet;
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
    private RoleRepository roleRepository;
    
    @Autowired
    private BCryptPasswordEncoder bcCryptPasswordEncoder;
    
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public User saveUser(User user) {
        
        user.setPassword(bcCryptPasswordEncoder.encode(user.getPassword()));
        
        user.setActive(1);
        
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(user);
        
    }
    
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
    
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    
}
