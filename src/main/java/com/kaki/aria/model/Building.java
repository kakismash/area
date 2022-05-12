/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.kaki.aria.model.view.Views;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author alfia
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "building")
@JsonView({ Building.class, User.class })
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Building implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "building_id")
    private long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @Column(name = "date_updated")
    private Date dateUpdated;

    @Column(name = "date_created")
    private Date dateCreated;

    @JsonView(Apartment.class)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
    private Collection<Apartment> apartments;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "building")
    private Collection<Floor> floors;

    @JsonView(Views.UserList.class)
    @ManyToMany(mappedBy = "buildings", fetch = FetchType.LAZY)
    private Collection<User> users;

}
