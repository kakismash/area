/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kaki.aria.controller;

import com.kaki.aria.model.Document;
import com.kaki.aria.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jose
 */
@RestController
@RequestMapping("/document")
public class DocumentController {
    
    @Autowired
    private DocumentService documentService;
    
    @PreAuthorize("permitAll()")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    public Document save(@RequestBody Document document){
        return documentService.saveDocument(document);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Document> list(){
        return documentService.findAll();
    }
    
    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteById(@PathVariable Long id){
        documentService.deleteDocument(id);
    }
    
    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Document findById(@PathVariable Long id){
        return documentService.findById(id);
    } 
    
}
