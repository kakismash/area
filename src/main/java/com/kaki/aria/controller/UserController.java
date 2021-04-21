/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kaki.aria.config.JWTU;
import com.kaki.aria.model.User;
import com.kaki.aria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @Autowired
    private BCryptPasswordEncoder bcCryptPasswordEncoder;
    
    @Autowired
    private JWTU jwtUtil;
    
    
    @JsonView(User.class)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody User user) {
        user.setPassword(bcCryptPasswordEncoder.encode(user.getPassword()));
        user.setToken(jwtUtil.generateToken(user));
        user.setEnabled(true);
        return userService.saveUser(user);
    }
    
    @PutMapping(path = "/{id}/savePassword" ,consumes = MediaType.APPLICATION_JSON_VALUE,
                                             produces = MediaType.APPLICATION_JSON_VALUE)
    public User savePassword(@RequestBody String password, @PathVariable long id) {
        return userService.savePassword(id, password);
    }
    
    @GetMapping(path = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User user(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }
    
    @JsonView(User.class)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> list() {
        return userService.findAll();
    }
    
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
    @JsonView(User.class)
    @PatchMapping(path = "/{id}/role/{roleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User addRole(@PathVariable long id, @PathVariable long roleId) {
        return userService.addRole(id, roleId);
    }
    
    @JsonView(User.class)
    @DeleteMapping(path = "/{id}/role/{roleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User deleteRole(@PathVariable long id, @PathVariable long roleId) {
        return userService.removeRole(id, roleId);
    }
    
    @JsonView(User.class)
    @PatchMapping(path = "/{id}/building/{buildingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User addBuilding(@PathVariable long id, @PathVariable long buildingId) {
        return userService.addBuilding(id, buildingId);
    }
    
    @JsonView(User.class)
    @DeleteMapping(path = "/{id}/building/{buildingId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User deleteBuilding(@PathVariable long id, @PathVariable long buildingId) {
        return userService.removeBuilding(id, buildingId);
    }
    
       
}
