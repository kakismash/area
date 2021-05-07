/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.kaki.aria.model.Apartment;
import com.kaki.aria.model.Building;
import com.kaki.aria.model.Floor;
import com.kaki.aria.service.ApartmentService;
import com.kaki.aria.service.BuildingService;
import com.kaki.aria.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jose
 */
@RestController
@RequestMapping("/building")
public class BuildingController {
    
    @Autowired
    private BuildingService buildingService;
    
    @Autowired
    private ApartmentService apartmentService;
    
    @Autowired
    private FloorService floorService;
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public Building save(@RequestBody Building building){
        return buildingService.saveBuilding(building);
    }
    
    @JsonView(Building.class)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Building> list(){
        return buildingService.findAll();
    }
    
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long id){
        buildingService.deleteBuilding(id);
    }
    
    @JsonView(Building.class)
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Building findById(@PathVariable Long id){
        return buildingService.findById(id);
    }
    
    @JsonView(Apartment.class)
    @GetMapping(path = "/{id}/apartment", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Apartment> listApartmentsByBuildingId(@PathVariable Long id){
        return apartmentService.listApartmentByBuildingId(id);
    }
    
    @JsonView(Building.class)
    @PatchMapping(path = "/{id}/floor/{floors}",  
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public Building addFloors(@PathVariable Long id, @PathVariable int floors) {
        return buildingService.saveFloors(id, floors);
    }
    
    @JsonView(Building.class)
    @DeleteMapping(path = "/{id}/floor", 
                   produces = MediaType.APPLICATION_JSON_VALUE)
    public Building removeFloors(@PathVariable Long id) {
        return buildingService.removeFloors(id);
    }
    
    @JsonView(Building.class)
    @DeleteMapping(path = "/{id}/floor/{floorId}", 
                   produces = MediaType.APPLICATION_JSON_VALUE)
    public Building removeFloor(@PathVariable Long id, @PathVariable Long floorId) {
        return buildingService.removeFloor(id, floorId);
    }
    
    @JsonView(Floor.class)
    @GetMapping(path = "/{id}/floor", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Floor> listFloorsByBuildingId(@PathVariable Long id){
        return floorService.listFloorByBuildingId(id);
    }
    
    
}
