/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.config;

import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Jose
 */
@Data
@NoArgsConstructor
public class LoginRequest implements Serializable {

    private static final long serialVersionUID = -4529654865154805133L;

    private String username;
    private String password;

    public LoginRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }
}
