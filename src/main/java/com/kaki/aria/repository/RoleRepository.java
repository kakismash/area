/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.repository;

import com.kaki.aria.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alfia
 */
@Repository("roleRepository")
public interface RoleRepository extends CrudRepository<Role, Long>{
    
    Role findRoleByName(String name);
    
}
