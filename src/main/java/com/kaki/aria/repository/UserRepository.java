/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.repository;

import com.kaki.aria.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alfia
 */
@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long>{
    
    User findByUsername(String username);
    
    User findByToken(String token);
    
    @Modifying
    @Query("update User u set u.token = :token where u.id = :id")
    void updateToken(@Param(value = "id") long id, @Param(value = "token") String token);
    
}
