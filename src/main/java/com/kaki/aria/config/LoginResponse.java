/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.config;

import java.io.Serializable;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Jose
 */
@Data
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = -2265001769007609269L;
    private final String token;
    private final UserDetails user;

    public LoginResponse(String token, UserDetails user) {
        this.token = token;
        this.user  = user;
    }
}
