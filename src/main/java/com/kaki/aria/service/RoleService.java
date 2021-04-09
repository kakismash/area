/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.service;

import com.kaki.aria.model.Role;
import com.kaki.aria.repository.RoleRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alfia
 */

@Service("roleService")
public class RoleService {
    
    RoleRepository roleRepo;
    
    public Role findById(long roleId) {
        return roleRepo.findById(roleId).orElseGet(null);
    }
    
    
    @Transactional
    public List<Role> findAll() {
        
        List<Role> roles = new ArrayList<Role>();
        
        try {
        
            roles.addAll(roleRepo.findAll());
            
        } catch (NullPointerException e) {
            
            System.out.println("This table is empty");
            
        }
        
        return roles;
    }
    
    public void deleteRole(long roleId) {
        roleRepo.deleteById(roleId);
    }
    
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }
    
}
