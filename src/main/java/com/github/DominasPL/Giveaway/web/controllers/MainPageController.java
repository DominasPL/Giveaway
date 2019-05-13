package com.github.DominasPL.Giveaway.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainPageController {

    @GetMapping
    public String showMainPage() {

        return "index";
    }

    @GetMapping("/about-service")
    public String showAboutService() {

        return "about-service";
    }

    @GetMapping("/about-us")
    public String showAboutUs() {

        return "about-us";
    }

    @GetMapping("/organizations")
    public String showOrganizations() {

        return "organizations";
    }

    @GetMapping("/contact")
    public String showContact() {

        return "contact";
    }


}
