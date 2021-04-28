/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kaki.aria.model.Role;
import com.kaki.aria.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jose
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    private RoleService roleService;
    
    @JsonView(Role.class)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public Role save(@RequestBody Role role){
        return roleService.saveRole(role);
    }
    
    @JsonView(Role.class)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Role> list(){
        return roleService.findAll();
    }
    
    @JsonView(Role.class)
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long id){
        roleService.deleteRole(id);
    }
    
    @JsonView(Role.class)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Role findById(@PathVariable Long id){
        return roleService.findById(id);
    }
    
}

