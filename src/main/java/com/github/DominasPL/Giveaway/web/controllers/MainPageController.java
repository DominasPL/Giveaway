package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class MainPageController {

    private UserService userService;

    public MainPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showMainPage(Model model) {

        return "index";
    }

    @GetMapping("about-service")
    public String showAboutService() {

        return "about-service";
    }

    @GetMapping("about-us")
    public String showAboutUs() {

        return "about-us";
    }

    @GetMapping("organizations")
    public String showOrganizations() {

        return "organizations";
    }

    @GetMapping("contact")
    public String showContact() {

        return "contact";
    }


}
