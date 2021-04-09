/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.service;

import com.kaki.aria.model.Apartment;
import com.kaki.aria.repository.ApartmentRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author alfia
 */
@Service("apartmentService")
public class ApartmentService {
    
    ApartmentRepository apartmentRepo;
    
    public List<Apartment> findByBuilding(long buildingId) {
        return apartmentRepo.findAllByBuildingId(buildingId);
    }
    
   
    public List<Apartment> findAll() {
        
        List<Apartment> apartments = new ArrayList<Apartment>();
        
        try {
        
            apartments.addAll(apartmentRepo.findAll());
            
        } catch (NullPointerException e) {
            
            System.out.println("This table is empty");
            
        }
        
        return apartments;
    }
    
    public void deleteApartment(long id) {
        apartmentRepo.deleteById(id);
    }
    
    public Apartment saveApartment(Apartment apartment) {
        return apartmentRepo.save(apartment);
    }
    
    public Apartment findByApartmentId(long apartmentId) {
        return apartmentRepo.findById(apartmentId);
    }
    
}
