/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.controller;

import com.kaki.aria.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alfia
 */
@RestController
@RequestMapping("/twilio")
public class TwilioController {
    
    @Autowired
    private TwilioService twilioService;
    
    @GetMapping()
    public void sendMessage(@RequestParam("number") String number, @RequestParam("message") String message) {
        twilioService.sendMessage(number, message);
    }
    
}
