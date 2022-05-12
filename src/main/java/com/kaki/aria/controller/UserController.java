/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kaki.aria.model.Building;
import com.kaki.aria.model.User;
import com.kaki.aria.model.view.Views;
import com.kaki.aria.model.view.changePassword;
import com.kaki.aria.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
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
    
    @JsonView(User.class)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @CrossOrigin
    @JsonView(Views.Password.class)
    @PutMapping(path = "/changePassword" , consumes = MediaType.APPLICATION_JSON_VALUE,
                                           produces = MediaType.APPLICATION_JSON_VALUE)
    public void changePassword(@RequestHeader("Authorization") String token, 
                               @RequestBody changePassword passwords) {
        userService.changePassword(token, passwords);
    }
    
    @JsonView(User.class)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public User savePassword(@RequestBody User user) {
        return userService.savePassword(user.getId(), user.getPassword());
    }
    
    @JsonView(User.class)
    @GetMapping(path = "/{id}", 
                produces = MediaType.APPLICATION_JSON_VALUE)
    public User user(@PathVariable long id) {
        return userService.findUserById(id);
    }
    
//    @GetMapping(path = "/{username}", 
//                produces = MediaType.APPLICATION_JSON_VALUE)
//    public User user(@PathVariable String username) {
//        return userService.findUserByUsername(username);
//    }
    
    @JsonView(User.class)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> list() {
        return userService.findAll();
    }
    
    @DeleteMapping(path = "/{id}", 
                   produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long id) {
        userService.deleteUser(id);
    }
    
    @JsonView(Building.class)
    @GetMapping(path = "/{id}/building", 
                  produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Building> buildingsByUser(@PathVariable long id) {
        return userService.buildingsByUser(id);
    }
    
    @JsonView(User.class)
    @PatchMapping(path = "/{id}/building/{buildingId}", 
                  produces = MediaType.APPLICATION_JSON_VALUE)
    public User addBuilding(@PathVariable long id, @PathVariable long buildingId) {
        return userService.addBuilding(id, buildingId);
    }
    
    @JsonView(User.class)
    @DeleteMapping(path = "/{id}/building/{buildingId}", 
                   produces = MediaType.APPLICATION_JSON_VALUE)
    public User deleteBuilding(@PathVariable long id, @PathVariable long buildingId) {
        return userService.removeBuilding(id, buildingId);
    }
       
}
