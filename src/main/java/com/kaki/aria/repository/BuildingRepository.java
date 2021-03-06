/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.repository;

import com.kaki.aria.model.Apartment;
import com.kaki.aria.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alfia
 */
@Repository("buildingRepository")
public interface BuildingRepository extends JpaRepository<Building, Long>{
    
    Building findById(long id);
    
}
