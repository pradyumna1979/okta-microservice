package com.american.express.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class OktaConfig {
    @Bean
    public SecurityFilterChain securityWebFilterChain(HttpSecurity httpSecurity) throws Exception {
       return httpSecurity
                //cors().disable()
                //.csrf().disable()
                .authorizeHttpRequests().requestMatchers("/").permitAll()
                .and()
                .authorizeHttpRequests().anyRequest().authenticated()
                .and()
                .oauth2Client()
                .and().logout().logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .and()
                .build();
    }

}
