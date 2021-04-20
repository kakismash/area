/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author alfia
 */
@Entity
@Table(name = "building")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(Building.class)
public class Building {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "building_id")
    private long id;
    
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description")
    private String description;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
    @Cascade(CascadeType.ALL)
    private Collection<Apartment> apartments;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "buildings", fetch = FetchType.LAZY)
    private Collection<User> users;
    
}
