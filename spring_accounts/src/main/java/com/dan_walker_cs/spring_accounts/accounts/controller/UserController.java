package com.dan_walker_cs.spring_accounts.accounts.controller;


import com.dan_walker_cs.spring_accounts.accounts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;


@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;


    // Displays the user.html template
    @RequestMapping("/user/{username}")
    public String userPage(ModelMap model, Principal principal, @PathVariable String username) {
        // current authenticated principal for the session
        final String currentUser = principal.getName();

        model.addAttribute("user", currentUser);

        return "user";
    }
}
