/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.service;

import com.fasterxml.jackson.annotation.JsonView;
import com.kaki.aria.model.Role;
import com.kaki.aria.repository.RoleRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alfia
 */

@Service("roleService")
@Transactional
public class RoleService {
    
    @Autowired
    RoleRepository roleRepo;
    
    @Transactional
    public Role findById(long roleId) {
        return roleRepo.findById(roleId).orElseGet(null);
    }
    
    public List<Role> findAll() {
       return roleRepo.findAll();
    }
    
    public void deleteRole(long roleId) {
        roleRepo.deleteById(roleId);
    }
    
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }
    
}
