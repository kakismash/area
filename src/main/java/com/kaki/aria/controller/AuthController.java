/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kaki.aria.config.JWTU;
import com.kaki.aria.config.LoginRequest;
import com.kaki.aria.service.UserService;
import com.kaki.aria.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;

/**
 *
 * @author Jose
 */
@RestController
@RequestMapping("/auth")
@PreAuthorize("permitAll()")
public class AuthController {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private JWTU jwtUtil;
    
    @PostMapping("/login")
    @JsonView(User.class)
    public User login(@RequestBody LoginRequest request) {
        
        final User user = userService.findUserByUsername(request.getUsername());
        
        if (userService.passwordValidation(request.getPassword(), user)) {
        
            user.setToken(jwtUtil.generateToken(user));
        
        } else {
            throw  new BadCredentialsException("1000");
        }
        
        return user;
    }
    
    private void authenticate(String username, String password){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, 
                                                                                   password));
    }
    
}
