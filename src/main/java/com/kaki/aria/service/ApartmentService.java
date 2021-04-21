/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.service;

import com.kaki.aria.model.Apartment;
import com.kaki.aria.repository.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author alfia
 */
@Service("apartmentService")
public class ApartmentService {
    
    @Autowired
    ApartmentRepository apartmentRepo;
    
    public Iterable<Apartment> findByBuilding(long buildingId) {
        return apartmentRepo.findAllByBuildingId(buildingId);
    }
   
    public Iterable<Apartment> findAll() {
        return apartmentRepo.findAll();
    }
    
    public void deleteApartment(long id) {
        apartmentRepo.deleteById(id);
    }
    
    public Apartment saveApartment(Apartment apartment) {
        return apartmentRepo.save(apartment);
    }
    
    public Apartment findById(long apartmentId) {
        return apartmentRepo.findById(apartmentId);
    }
    
}
