package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.domain.entities.ConfirmationToken;
import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.domain.repositories.ConfirmationTokenRepository;
import com.github.DominasPL.Giveaway.dtos.RegistrationFormDTO;
import com.github.DominasPL.Giveaway.dtos.UserDTO;
import com.github.DominasPL.Giveaway.services.EmailService;
import com.github.DominasPL.Giveaway.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.security.core.parameters.P;
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
    private ConfirmationTokenRepository confirmationTokenRepository;

    public RegistrationController(UserService userService, ConfirmationTokenRepository confirmationTokenRepository) {
        this.userService = userService;
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    @GetMapping
    public String prepareRegistrationForm(Model model) {

        model.addAttribute("form", new RegistrationFormDTO());
        return "registration-form";
    }

    @PostMapping
    public String processRegistration(@Valid @ModelAttribute("form") RegistrationFormDTO form, BindingResult result, Model model) {

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

        model.addAttribute("email", form.getEmail());

        return "successfulRegistration";

    }

    @GetMapping("/confirm-account")
    public String confirmAccount(@RequestParam("token") String confirmationToken, Model model) {

        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {

            userService.activateUserAccount(token);

        } else {

            return "account-verification-error";

        }


        return "account-verified";

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
