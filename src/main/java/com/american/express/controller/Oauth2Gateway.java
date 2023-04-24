package com.american.express.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller

public class Oauth2Gateway {
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/profile")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    public ModelAndView userDetails(OAuth2AuthenticationToken authentication) {
        return new ModelAndView("userProfile" , Collections.singletonMap("details", authentication.getPrincipal().getAttributes()));
    }
}
