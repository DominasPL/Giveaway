package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.dtos.RegistrationFormDTO;
import com.github.DominasPL.Giveaway.dtos.UserDTO;
import com.github.DominasPL.Giveaway.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareRegistrationForm(Model model) {

        model.addAttribute("form", new RegistrationFormDTO());
        return "registration-form";
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("form") RegistrationFormDTO form, BindingResult result) {

        if (result.hasErrors()) {
            return "registration-form";
        }

        if (!checkPasswordsEquality(form)) {
            result.rejectValue("password", null, "Hasła nie są zgodne.");
            return "registration-form";
        }

        if (!checkEmailIsAvailable(form)) {
            result.rejectValue("email", null, "Email zajęty.");
            return "registration-form";
        }

        userService.registerUser(form);

        return "redirect:/";

    }

    public boolean checkEmailIsAvailable(RegistrationFormDTO form) {
        UserDTO userDTO = userService.findUserByEmail(form.getEmail());

        if (userDTO == null) {
            return true;
        }

        return false;
    }

    public boolean checkPasswordsEquality(RegistrationFormDTO form) {
        return form.getPassword().equals(form.getConfirmedPassword());
    }

}
