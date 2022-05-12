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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alfia
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "apartment")
@JsonView(Apartment.class)
public class Apartment implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apartment_id")
    private long id;
    
    @Column(name = "display", nullable = false)
    private String display;

    
    @Column(name = "description")
    private String description;
    
    @JsonView(Views.BuildingList.class)
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "apartments_floors", 
                joinColumns = @JoinColumn(name = "apartment_id", 
                              referencedColumnName = "apartment_id"), 
                inverseJoinColumns = @JoinColumn(name = "floor_id", 
                                     referencedColumnName = "floor_id"))
    private Collection<Floor> floors;

    public Apartment() {
    }

    public Apartment(long id, String display, String description, Building building, Collection<Floor> floors) {
        this.id             = id;
        this.display        = display;
        this.description    = description;
        this.building       = building;
        this.floors         = floors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
    
    public Collection<Floor> getFloors(){
        return floors;
    }
    
    public void setFloors(Collection<Floor> floors){
        this.floors = floors;
    }
    
}
