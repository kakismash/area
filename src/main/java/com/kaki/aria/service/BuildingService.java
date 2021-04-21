/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.service;

import com.kaki.aria.model.Building;
import com.kaki.aria.repository.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alfia
 */
@Service("buildingService")
public class BuildingService {
    
    @Autowired
    BuildingRepository buildingRepo;
    
    public Building findById(long buildingId) {
        return buildingRepo.findById(buildingId);
    }
    
    public Building saveBuilding(Building building) {
        return buildingRepo.save(building);
    }
    
    public void deleteBuilding(long buildingId) {
        buildingRepo.deleteById(buildingId);
    }
    
    public Iterable<Building> findAll() {
        
        Iterable<Building> b = buildingRepo.findAll();
        
        System.out.println(b.toString());
        
        return b;
    }
    
}
