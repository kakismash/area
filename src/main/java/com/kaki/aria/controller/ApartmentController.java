/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.controller;

import com.kaki.aria.model.Apartment;
import com.kaki.aria.service.ApartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jose
 */
@RestController
@RequestMapping("/apartment")
public class ApartmentController {
    
    @Autowired
    private ApartmentService apartmentService;
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public Apartment save(@RequestBody Apartment apartment){
        return apartmentService.saveApartment(apartment);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Apartment> list(){
        return apartmentService.findAll();
    }
    
    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Apartment> listByBuildingId(@PathVariable long buildingId){
        return apartmentService.findByBuilding(buildingId);
    }
    
    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable long id){
        apartmentService.deleteApartment(id);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Apartment findById(Long id){
        return apartmentService.findByApartmentId(id);
    }
    
}

