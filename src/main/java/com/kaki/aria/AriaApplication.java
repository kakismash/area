package com.kaki.aria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAsync
@EnableWebMvc
@EnableWebSecurity
public class AriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AriaApplication.class, args);
    }
          
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowCredentials(false)
                        .allowedHeaders("*")
                        .allowedMethods("*");
                
                System.out.println("**************adding cors*************");
            }
        };
    }
    
//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//
//        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
//        
//        
//        source.registerCorsConfiguration("/**", corsConfiguration);
//
//        System.out.println("Cors Configuration Source");
//        
//        return source;
//    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        
        return new BCryptPasswordEncoder();
    
    }
    
}
