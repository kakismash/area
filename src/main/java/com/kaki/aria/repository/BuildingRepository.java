/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.repository;

import com.kaki.aria.model.Building;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alfia
 */
@Repository("buildingRepository")
public interface BuildingRepository extends CrudRepository<Building, Long>{
    
    Building findById(long id);
    
    @Query("SELECT b FROM Building b LEFT JOIN b.users u WHERE u.id =:id")
    Iterable<Building> findByUserId(@Param("id") long id);
}
