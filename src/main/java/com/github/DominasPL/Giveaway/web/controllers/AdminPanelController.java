package com.github.DominasPL.Giveaway.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/panel")
public class AdminPanelController {

    @GetMapping
    public String displayAdminMainPage(Model model) {


        return "admin-panel";
    }

}
