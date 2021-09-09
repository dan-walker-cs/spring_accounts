package com.dan_walker_cs.spring_accounts.accounts.controller;

import com.dan_walker_cs.spring_accounts.accounts.model.User;
import com.dan_walker_cs.spring_accounts.accounts.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    // Displays the register.html template
    @RequestMapping("/register")
    public String registrationPage(Model model, Principal principal) {
        if (principal != null) {
            return "redirect:/user/" + principal.getName();
        }

        User user = new User();
        model.addAttribute("user", user);

        return "register";
    }

    // Pulls data from the registration template
    @PostMapping("/register")
    public String createUser(User user) {
        // default data
        user.setActive(true);
        user.setRoles("ROLE_USER");

        userRepository.save(user);
        return "redirect:/home";
    }
}
