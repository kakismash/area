/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.kaki.aria.model;

import com.fasterxml.jackson.annotation.JsonView;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate; //---Import the LocalDate class
/**
 *
 * @author Jose
 */

@Entity
@Table(name = "document")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(Document.class)
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "document_id")
    private long id;
    
    @Column(name = "path")
    private String path;

    @Column(name = "name")
    private String name;

    @Column(name = "fileType")
    private String fileType;

    @Column(name = "size")
    private long size;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private LocalDate created;

    @Column(name = "updated")
    private LocalDate updated;

}
