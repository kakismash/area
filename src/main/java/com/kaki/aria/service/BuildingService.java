/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.service;

import com.kaki.aria.model.Building;
import com.kaki.aria.repository.BuildingRepository;
import java.util.List;
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
    
    public Building findByBuildingId(long buildingId) {
        return buildingRepo.findById(buildingId);
    }
    
    public Building saveBuilding(Building building) {
        return buildingRepo.save(building);
    }
    
    public void deleteBuilding(long buildingId) {
        buildingRepo.deleteById(buildingId);
    }
    
    public List<Building> findAll() {
        return buildingRepo.findAll();
    }
    
}
