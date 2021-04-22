/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 *
 * @author alfia
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "building")
@JsonView(Building.class)
public class Building implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "building_id")
    private long id;
    
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
    private Collection<Apartment> apartments;
    
    @JsonView(User.class)
    @ManyToMany(mappedBy = "buildings", fetch = FetchType.LAZY)
    private Collection<User> users;

    public Building() {
    }

    public Building(long id, String name, String description, Collection<Apartment> apartments, Collection<User> users) {
        this.id                 = id;
        this.name               = name;
        this.description        = description;
        this.apartments         = apartments;
        this.users              = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(Collection<Apartment> apartments) {
        this.apartments = apartments;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    
    
    
}
