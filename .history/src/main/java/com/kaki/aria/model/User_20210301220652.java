/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.NoArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author alfia
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity()
@Table(name = "countries")
@NoArgsConstructor
public class User implements Serializable, UserDetails {

}
