package com.kaki.aria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AriaApplication.class, args);
    }
        
}
