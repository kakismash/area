/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.repository;

import com.kaki.aria.model.Floor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jose
 */
@Repository("floorRepository")
public interface FloorRepository extends CrudRepository<Floor, Long>{
    
    Iterable<Floor> findAllByBuildingId(long buildingId);

    Floor findById(long floorId);
    
    @Query("SELECT f FROM Floor f LEFT JOIN f.building f WHERE f.id =:id")
    Iterable<Floor> findByBuildingId(@Param("id") long id);
}
