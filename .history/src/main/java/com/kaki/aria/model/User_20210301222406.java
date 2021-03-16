/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author alfia
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity()
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable, UserDetails {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    public String getUsername() {
        return this.email;
    }

    public void setUsername(String email) {
        this.email = email;
    }

}
