package com.example.ceylonestate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class PropertySecurityConfig {

    @Bean
    @Order(1)
    public SecurityFilterChain propertyFilterChain(HttpSecurity http)
            throws Exception {

        http
                .securityMatcher("/properties/**")
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}