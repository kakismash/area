/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.kaki.aria.model.view.Views.Password;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
/**
 *
 * @author alfia
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "user")
@JsonView(User.class)
public class User implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "firstname", nullable = false)
    private String firstname; 

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @JsonView(Password.class)
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = true)
    private boolean enabled;
    
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "social_security", nullable = true, unique = true, length = 9)
    private String socialSecurity;

    @Column(name = "account_expired", nullable = true)
    private Date accountExpired;

    @Column(name = "account_blocked", nullable = true)
    private Date accountBlocked;

    @Column(name = "password_expired", nullable = true)
    private Date passwordExpired;
    
    @Column(name = "token", nullable = true)
    private String token;
    
    @Column(nullable = true)
    private Integer defaultBuilding;
    
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", 
                joinColumns = @JoinColumn(name = "user_id", 
                              referencedColumnName = "user_id"), 
                inverseJoinColumns = @JoinColumn(name = "role_id", 
                                     referencedColumnName = "role_id"))
    private Collection<Role> roles;
    
    @JsonView(Building.class)
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_buildings", 
                joinColumns = @JoinColumn(name = "user_id", 
                              referencedColumnName = "user_id"), 
                inverseJoinColumns = @JoinColumn(name = "building_id", 
                                     referencedColumnName = "building_id"))
    private Collection<Building> buildings;

    public User() {
    }

    public User(long id, String username, String firstname, String lastname, String password, boolean enabled, String phoneNumber, String socialSecurity, Date accountExpired, Date accountBlocked, Date passwordExpired, String token, Integer defaultBuilding, Collection<Role> roles, Collection<Building> buildings) {
        this.id                 = id;
        this.username           = username;
        this.firstname          = firstname;
        this.lastname           = lastname;
        this.password           = password;
        this.enabled            = enabled;
        this.phoneNumber        = phoneNumber;
        this.socialSecurity     = socialSecurity;
        this.accountExpired     = accountExpired;
        this.accountBlocked     = accountBlocked;
        this.passwordExpired    = passwordExpired;
        this.token              = token;
        this.defaultBuilding    = defaultBuilding;
        this.roles              = roles;
        this.buildings          = buildings;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public Date getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(Date accountExpired) {
        this.accountExpired = accountExpired;
    }

    public Date getAccountBlocked() {
        return accountBlocked;
    }

    public void setAccountBlocked(Date accountBlocked) {
        this.accountBlocked = accountBlocked;
    }

    public Date getPasswordExpired() {
        return passwordExpired;
    }

    public void setPasswordExpired(Date passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getDefaultBuilding() {
        return defaultBuilding;
    }

    public void setDefaultBuilding(Integer defaultBuilding) {
        this.defaultBuilding = defaultBuilding;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public Collection<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(Collection<Building> buildings) {
        this.buildings = buildings;
    }
    
    
    
}
