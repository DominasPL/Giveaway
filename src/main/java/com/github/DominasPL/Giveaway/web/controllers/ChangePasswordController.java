package com.github.DominasPL.Giveaway.web.controllers;


import com.github.DominasPL.Giveaway.dtos.ChangePasswordDTO;
import com.github.DominasPL.Giveaway.dtos.RegistrationFormDTO;
import com.github.DominasPL.Giveaway.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/profile/change-password")
public class ChangePasswordController {

    private UserService userService;

    public ChangePasswordController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayForm(Model model) {

        model.addAttribute("form", new ChangePasswordDTO());

        return "change-password";

    }

    @PostMapping
    public String changePassword(@Valid @ModelAttribute("form") ChangePasswordDTO form, Principal principal, BindingResult result) {

        if (result.hasErrors()) {
            return "change-password";
        }

        if (!checkPasswordsEquality(form)) {
            result.rejectValue("password", null, "Hasła są niezgodne");
            return "change-password";
        }

        userService.editUserPassword(form, principal.getName());

        return "redirect:/profile";

    }

    public boolean checkPasswordsEquality(ChangePasswordDTO form) {
        return form.getPassword().equals(form.getConfirmedPassword());
    }


}
