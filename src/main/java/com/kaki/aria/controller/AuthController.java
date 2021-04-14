/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.controller;

import com.kaki.aria.config.JwtUtil;
import com.kaki.aria.config.LoginRequest;
import com.kaki.aria.config.LoginResponse;
import com.kaki.aria.service.UserService;
import com.kaki.aria.model.User;
import com.kaki.aria.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author Jose
 */
@RestController
@RequestMapping("/auth")
@PreAuthorize("permitAll()")
public class AuthController {
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    UserService userService;
    
    @Autowired
    RoleService rolService;
    
    @Autowired
    User user;
    
    @Autowired
    JwtUtil jwtUtil;
    
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        authenticate(request.getUsername(), request.getPassword());
        final User user = userService.findUserByUsername(request.getUsername());
        return new LoginResponse(jwtUtil.generateToken(user), user);
    }
    
    private void authenticate(String username, String password){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, 
                                                                                   password));
    }
    
}
