package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoggedPageController {

    private UserService userService;

    public LoggedPageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String displayUserMainPage() {

        return "logged-user-page";
    }

    @GetMapping("/admin")
    public String displayAdminMainPage(Model model) {


        return "logged-admin-page";
    }

}
