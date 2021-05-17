/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.service;

import com.kaki.aria.model.Building;
import com.kaki.aria.model.Floor;
import com.kaki.aria.repository.BuildingRepository;
import com.kaki.aria.repository.FloorRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alfia
 */
@Service("buildingService")
public class BuildingService {
    
    @Autowired
    BuildingRepository buildingRepo;
    
    @Autowired
    FloorService floorService;
    
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
    
    @Transactional
    public Building saveFloors(long buildingId, List<Floor>  floors) {
        
        Building building = buildingRepo.findById(buildingId);
        
        if (building.getFloors() != null && 
                building.getFloors().size() > 0) {
            floorService.removeFloors(building.getFloors());
        }
        
        floors = floorService.createFloors(buildingId, floors);
        building.setFloors(floors);
        buildingRepo.save(building);
        
        return building;
        
    }
    
    @Transactional
    public Building removeFloors(long buildingId) {
        
        Building building = buildingRepo.findById(buildingId);
        
        floorService.removeFloors(building.getFloors());
        
        building.setFloors(new ArrayList<Floor>());
        
        buildingRepo.save(building);
        
        return building;
        
    }
    
    @Transactional
    public Building removeFloor(long buildingId, long floorId) {
        
        Building building = buildingRepo.findById(buildingId);
        
        floorService.removeFloor(floorId);
        
        building.getFloors().removeIf(f -> f.getId() == floorId);
        
        building.setFloors(building.getFloors());
        
        buildingRepo.save(building);
        
        return building;
        
    }
    
}
