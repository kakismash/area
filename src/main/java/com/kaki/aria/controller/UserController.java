/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.controller;

import com.kaki.aria.model.User;
import com.kaki.aria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author alfia
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @PreAuthorize("permitAll()")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }
    
    @GetMapping(path = "/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User user(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> list() {
        return userService.findAll();
    }
    
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteByEmail(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
    
    
}
