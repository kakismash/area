/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.repository;

import com.kaki.aria.model.Apartment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alfia
 */
@Repository("apartmentRepository")
public interface ApartmentRepository extends CrudRepository<Apartment, Long>{
    
    Iterable<Apartment> findAllByBuildingId(long buildingId);

    Apartment findById(long apartmentId);
    
    @Query("SELECT a FROM Apartment a LEFT JOIN a.building b WHERE b.id =:id")
    Iterable<Apartment> findByBuildingId(@Param("id") long id);
    
}
