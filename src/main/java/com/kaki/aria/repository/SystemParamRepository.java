/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.repository;

import com.kaki.aria.model.GlobalSetting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author alfia
 */
@Repository("systemParamRepository")
public interface SystemParamRepository extends CrudRepository<GlobalSetting, Long>{
    
    public GlobalSetting findByName(String name);
    
}
