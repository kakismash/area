/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.service;

import com.kaki.aria.model.Building;
import com.kaki.aria.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaki.aria.model.Floor;
import com.kaki.aria.repository.BuildingRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Jose
 */
@Service("floorService")
public class FloorService {
    
    @Autowired
    FloorRepository floorRepo;
    
    @Autowired
    BuildingService buildingService;
    
    @Autowired
    BuildingRepository buildingRepo;
    
    public Floor findById(long floorId) {
        return floorRepo.findById(floorId);
    }
    
    public Iterable<Floor> findAll() {
        return floorRepo.findAll();
    }
    
    public void deleteFloor(long floorId) {
        floorRepo.deleteById(floorId);
    }
    
    public Floor saveFloor(Floor floor) {
        return floorRepo.save(floor);
    }
    
    public List<Floor> createFloorsFromQuantity(int quantity, long buildingId) {
        
        List<Floor> floors = new ArrayList();
        
        for (int a = 0; a < quantity; a++ ) {
            Floor f = new Floor();
            f.setBuilding(buildingService.findById(buildingId));
            floors.add(f);
        }
        
        floorRepo.saveAll(floors);
        
        return floors;
        
    }
    
    
    @Transactional
    public void removeFloors(Collection<Floor> floors) {
        floorRepo.deleteAll(floors);
    }
    
    public void removeFloor(long floorId) {
        floorRepo.deleteById(floorId);
    }
    
    public Iterable<Floor> listFloorByBuildingId(long buildingId) {
        return floorRepo.findAllByBuildingId(buildingId);
    }
    
}
