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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author alfia
 */

@Entity
@Table(name = "apartment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonView(Apartment.class)
public class Apartment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "apartment_id")
    private long id;
    
    @Column(name = "display", nullable = false)
    private String display;

    @Column(name = "description")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;
    
}
