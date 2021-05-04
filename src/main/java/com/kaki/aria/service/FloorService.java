/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.service;

import com.kaki.aria.repository.FloorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaki.aria.model.Floor;

/**
 *
 * @author Jose
 */
@Service("floorService")
public class FloorService {
    
    @Autowired
    FloorRepository floorRepo;
    
    public Floor findById(long floorId) {
        return floorRepo.findById(floorId).orElseGet(null);
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
    
    
}
