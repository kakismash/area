/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.repository;

import com.kaki.aria.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alfia
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByUsername(String username);
    
}
