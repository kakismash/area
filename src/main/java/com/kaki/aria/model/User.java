/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author alfia
 */
@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
 
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "user_id")
 private long id;
 
 @Column(name = "email")
 private String email;
 
 @Column(name = "firstname")
 private String firstname; 
 
 @Column(name = "lastname")
 private String lastname;
 
 @Column(name = "password")
 private String password;
 
 @Column(name = "active")
 private int active;
 
 @Column(name = "phone_number")
 private String phoneNumber;
 
 @Column(name = "social_security")
 private int socialSecurity;
 
 @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
 @JoinTable(name="users_roles", 
            joinColumns=@JoinColumn(name = "user_id", 
                                    referencedColumnName = "user_id"), 
            inverseJoinColumns=@JoinColumn(name = "role_id", 
                                           referencedColumnName = "role_id"))
 private Set<Role> roles = new HashSet<Role>();
 
 public User(String email, String firstName, String lastname) {
     this.email         = email;
     this.firstname     = firstName;
     this.lastname      = lastname;
 }
    
}
