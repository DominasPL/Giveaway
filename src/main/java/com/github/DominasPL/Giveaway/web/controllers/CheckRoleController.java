package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.dtos.UserNameAndRoleDTO;
import com.github.DominasPL.Giveaway.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/check-role")
public class CheckRoleController {

    private UserService userService;

    public CheckRoleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String checkRole(Principal principal, Model model) {

        UserNameAndRoleDTO userDTO = userService.findUserNameAndRole(principal.getName());

        if (!userDTO.getActive()) {
            //TODO WYSWIETLIC KOMUNIKAT ZE KONTO JSET NIEAKTYWNE
            return "redirect:/logout";

        }

        if (userDTO.getRole().equals("ROLE_ADMIN")) {
            return "redirect:/admin/panel";
        }

        model.addAttribute("firstName", userDTO.getFirstName());

        return "index";
    }

}
