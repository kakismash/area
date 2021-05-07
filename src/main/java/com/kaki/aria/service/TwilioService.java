/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaki.aria.service;

import com.kaki.aria.model.GlobalSetting;
import com.kaki.aria.repository.SystemParamRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author alfia
 */
@Service("TwilioService")
@Transactional
public class TwilioService {

    private static String twilioAccount = "AC3f3060fab5a15d5c034e5196b496f9a2";
    
    
    @Autowired
    SystemParamRepository systemRepo;
    
    public void setAccount(String ACCOUNT_SID, String AUTH_TOKEN) {
        
        GlobalSetting system = systemRepo.findByName(ACCOUNT_SID);
        
        if (system == null) {
            system = new GlobalSetting();
        }
        
        system.setName(ACCOUNT_SID);
        system.setValue(AUTH_TOKEN);

        systemRepo.save(system);
    }
    
    public GlobalSetting getAccount(String ACCOUNT_SID) {
        
        return systemRepo.findByName(ACCOUNT_SID);
        
    }
    
    public void sendMessage(String number, String messageStr) {

        GlobalSetting twilioA = systemRepo.findByName(this.twilioAccount);
        
        Twilio.init(twilioA.getName(), twilioA.getValue());
        
        Message message = Message.creator(new PhoneNumber(number),
                                          new PhoneNumber("+19105071280"), 
                                          messageStr)
                                 .create();
        
        System.out.println(message.getSid());
    }
    
}
