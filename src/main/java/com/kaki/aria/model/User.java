/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.model;

import java.util.Collection;
import java.util.Collections;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author alfia
 */
@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
 
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 @Column(name = "user_id")
 private long id;
 
 @Column(name = "username", nullable = false, unique = true)
 private String username;
 
 @Column(name = "firstname", nullable = false)
 private String firstname; 
 
 @Column(name = "lastname", nullable = false)
 private String lastname;
 
 @Column(name = "password", nullable = false)
 private String password;
 
 @Column(name = "enabled")
 private int enabled;
 
 @Column(name = "phone_number", nullable = false, unique = true)
 private String phoneNumber;
 
 @Column(name = "social_security", nullable = false, unique = true)
 private int socialSecurity;
 
 @
 
 @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
 @JoinTable(name="users_roles", 
            joinColumns=@JoinColumn(name = "user_id", 
                                    referencedColumnName = "user_id"), 
            inverseJoinColumns=@JoinColumn(name = "role_id", 
                                           referencedColumnName = "role_id"))
 private Set<Role> roles = new HashSet<Role>();
 
 public User(String username, String firstName, String lastname) {
     this.username     = username;
     this.firstname    = firstName;
     this.lastname     = lastname;
 }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
