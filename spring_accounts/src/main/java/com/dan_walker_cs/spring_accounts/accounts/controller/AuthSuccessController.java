package com.dan_walker_cs.spring_accounts.accounts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@Controller
public class AuthSuccessController {

    @RequestMapping("/authsuccess")
    public String authSuccessRedirect(Principal principal, HttpServletRequest request) {
        if(request.isUserInRole("ADMIN")) {
            return "redirect:/admin";
        }
        return "redirect:/user/" + principal.getName();
    }
}
