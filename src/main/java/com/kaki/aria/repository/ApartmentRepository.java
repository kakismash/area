/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.repository;

import com.kaki.aria.model.Apartment;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alfia
 */
@Repository("apartmentRepository")
public interface ApartmentRepository extends CrudRepository<Apartment, Long>{
    
    Iterable<Apartment> findAllByBuildingId(long buildingId);

    Apartment findById(long apartmentId);
    
}
