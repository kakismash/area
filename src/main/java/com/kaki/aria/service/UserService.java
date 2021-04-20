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
import java.util.Collection;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author alfia
 */
@Service("userService")
public class UserService implements UserDetailsService{
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder bcCryptPasswordEncoder;
    
    @Autowired
    private RoleRepository roleRepository;
    
    public User findUserById(long userId) {
        return userRepository.findById(userId).orElse(null);
    }
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
    
    public boolean passwordValidation(String password, User user) {
        return bcCryptPasswordEncoder.matches(password, user.getPassword());
    }

    public User savePassword(long userId, String password) {
        
        User user = findUserById(userId);
        
        user.setPassword(bcCryptPasswordEncoder.encode(password));
        user.setEnabled(true);
        return userRepository.save(user); 
    }

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

}
