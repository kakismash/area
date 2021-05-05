/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.kaki.aria.model.view.Views;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Jose
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "floor")
@JsonView(Floor.class)
public class Floor implements Serializable{
    
    @JsonView({Floor.class, Building.class})
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "floor_id")
    private long id;

    @JsonView({Floor.class, Building.class})
    @Column(name = "name", nullable = true)
    private String name;
    
    @JsonView({Floor.class, Building.class})
    @Column(name = "type", nullable = true)
    private int type;
    
    @JsonView(Views.ApartmentList.class)
    @ManyToMany(mappedBy = "floors", fetch = FetchType.LAZY)
    private Collection<Apartment> apartments;
    
    @JsonView(Views.BuildingList.class)
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    
    
    public Floor(){}
    
    public Floor(long id, String name, Collection<Apartment> apartments, Building building){
        this.id         = id;
        this.name       = name;
        this.apartments = apartments;
        this.building   = building;
    }
    
    public long getId(){
        return id;
    }
    
    public void setId(long id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public Collection<Apartment> getApartments(){
        return apartments;
    }
    
    public void setApartments(Collection<Apartment> apartments){
        this.apartments = apartments;
    }
    
    public Building getBuilding(){
        return building;
    }
    
    public void setBuilding(Building building){
        this.building = building;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public static int RESIDENCIAL = 2;
    public static int COMMON      = 1;
    public static int MIX         = 3;  
}
