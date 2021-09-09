package com.dan_walker_cs.spring_accounts.accounts.controller;

import com.dan_walker_cs.spring_accounts.accounts.model.User;
import com.dan_walker_cs.spring_accounts.accounts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;


@Controller
public class AdminController {

    @Autowired
    UserRepository userRepository;

    // Displays the admin.html template
    @RequestMapping("/admin")
    public String adminPage(Model model, Principal principal) {
        // populates a list of users from the DB
        List<User> allUsers = this.userRepository.findAll();
        model.addAttribute("allUsers", allUsers);

        return "admin";
    }
}
