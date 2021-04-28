/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonObject;
import com.kaki.aria.config.JWTU;
import com.kaki.aria.model.Building;
import com.kaki.aria.model.Role;
import com.kaki.aria.model.User;
import com.kaki.aria.model.view.changePassword;
import com.kaki.aria.repository.BuildingRepository;
import com.kaki.aria.repository.RoleRepository;
import com.kaki.aria.repository.UserRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author alfia
 */
@Service("userService")
public class UserService implements UserDetailsService{
    
    @Autowired
    private BuildingRepository buildingRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder bcCryptPasswordEncoder;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private JWTU jwtUtil;
    
    @Transactional(readOnly = true)
    public User findUserById(long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    
    @Transactional(readOnly = true)
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public User saveUser(User user) {
        
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
        
            user.setPassword(bcCryptPasswordEncoder.encode(user.getPassword()));
        
        } else if (user.getId() != null) {
        
            User t = userRepository.findById(user.getId()).get();
            user.setPassword(t.getPassword());
        
        } else {
        
            user.setPassword(bcCryptPasswordEncoder.encode("123"));
            user.setEnabled(false);
        }
        return userRepository.save(user);      
    }
    
    @Transactional(readOnly = true)
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
    
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    public boolean passwordValidation(String password, User user) {
        return bcCryptPasswordEncoder.matches(password, user.getPassword());
    }
    
    public void changePassword(String token, changePassword passwords) {
        
        User user = findUserByToken(token.substring(7));
        
        if (passwordValidation(passwords.getOldPassword(), user)) {
            
            user.setPassword(bcCryptPasswordEncoder.encode(passwords.getNewPassword()));
            userRepository.save(user);
            
        } else {
            throw new ResponseStatusException(
                        HttpStatus.PRECONDITION_FAILED, "Password not match");
        }
        
    }

    public User savePassword(long userId, String password) {
        
        User user = findUserById(userId);
        
        user.setPassword(bcCryptPasswordEncoder.encode(password));
        return userRepository.save(user); 
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public User addRole(long userId, long roleId) {
         
        User user = findUserById(userId);
        
        Collection<Role> roles = user.getRoles();
        
        Role roleToAdd = roleRepository.findById(roleId).orElse(null);

        roles.add(roleToAdd);
        
        user.setRoles(roles);
        
        return userRepository.save(user);
        
    }
    
    public User removeRole(long userId, long roleId) {
        
        User user = findUserById(userId);
        
        Collection<Role> roles = user.getRoles();
        
        roles.removeIf(r -> r.getId() == roleId);
        
        user.setRoles(roles);
        
        return userRepository.save(user);
        
    }
    
    public User addBuilding(long userId, long buildingId) {
         
        User user = findUserById(userId);
        
        Collection<Building> buildings = user.getBuildings();
        
        Building buildingToAdd = buildingRepository.findById(buildingId);

        buildings.add(buildingToAdd);
        
        user.setBuildings(buildings);
        
        return userRepository.save(user);
        
    }
    
    public User removeBuilding(long userId, long buildingId) {
        
        User user = findUserById(userId);
        
        Collection<Building> buildings = user.getBuildings();
        
        buildings.removeIf(r -> r.getId() == buildingId);
        
        user.setBuildings(buildings);
        
        return userRepository.save(user);
        
    }
    
    public User findUserByToken(String token) {
        return userRepository.findByToken(token);
    }
    
    public void removeToken(User user) {
        
        user.setToken(null);
        
        userRepository.save(user);
    }
    
    public void saveToken(long userId, String token) {
        userRepository.updateToken(userId, token);
    }

}
