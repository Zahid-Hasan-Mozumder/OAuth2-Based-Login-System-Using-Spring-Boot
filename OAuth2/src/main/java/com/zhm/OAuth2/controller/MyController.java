package com.zhm.OAuth2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/")
    public String showDashboard(@AuthenticationPrincipal OAuth2User oAuth2User, Model theModel){
        String username = oAuth2User.getAttribute("name");
        if(username != null){
            theModel.addAttribute("username", username);
        }
        else{
            theModel.addAttribute("username", "user");
        }
        return "dashboard";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

}
