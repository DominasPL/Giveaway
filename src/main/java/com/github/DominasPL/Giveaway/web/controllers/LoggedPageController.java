package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoggedPageController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private UserService userService;

    public LoggedPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String displayUserMainPage() {

        return "logged-user-page";
    }

    @GetMapping("/admin")
    public String displayAdminMainPage() {

       userService.loadAllAdmins();

        return "logged-admin-page";
    }

}
