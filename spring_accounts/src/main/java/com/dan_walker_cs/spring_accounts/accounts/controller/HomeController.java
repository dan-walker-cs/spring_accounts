package com.dan_walker_cs.spring_accounts.accounts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {

    // Redirects the default URL to the home page URL
    @RequestMapping({"/home","/"})
    public String homePage(Model model, Principal principal) {
        return "home";
    }
}
