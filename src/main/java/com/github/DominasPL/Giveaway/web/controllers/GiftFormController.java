package com.github.DominasPL.Giveaway.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gift")
public class GiftFormController {

    @GetMapping
    public String displayGiftForm(Model model) {


        return "gift-form";
    }



}
