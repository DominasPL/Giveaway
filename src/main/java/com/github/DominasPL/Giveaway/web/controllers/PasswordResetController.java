package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.domain.entities.PasswordResetToken;
import com.github.DominasPL.Giveaway.domain.repositories.PasswordResetTokenRepository;
import com.github.DominasPL.Giveaway.dtos.ChangePasswordDTO;
import com.github.DominasPL.Giveaway.dtos.EmailDTO;
import com.github.DominasPL.Giveaway.dtos.UserDTO;
import com.github.DominasPL.Giveaway.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/password-reset")
public class PasswordResetController {

    private UserService userService;
    private PasswordResetTokenRepository passwordResetTokenRepository;

    public PasswordResetController(UserService userService, PasswordResetTokenRepository passwordResetTokenRepository) {
        this.userService = userService;
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }

    @GetMapping
    public String displayEmailForm(Model model) {

        model.addAttribute("email", new EmailDTO());

        return "reset-email";

    }

    @PostMapping
    public String resetPassword(@Valid @ModelAttribute("email") EmailDTO emailDTO, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "reset-email";
        }

        if (!checkIsEmailInDatabase(emailDTO.getEmail())) {
            result.rejectValue("email", null, "Email nie znaleziony.");
            return "reset-email";
        }

        //TODO WYSYLANIE MAILA RESETUJACEGO
        userService.sendPasswordResetEmail(emailDTO.getEmail());

        model.addAttribute("email", emailDTO.getEmail());

        return "successfulEmailSend";

    }

    @GetMapping("/reset")
    public String displayPasswordResetForm(Model model, @RequestParam("token") String passwordResetToken) {

        PasswordResetToken token = passwordResetTokenRepository.findByPasswordResetToken(passwordResetToken);

        if (token != null) {
            model.addAttribute("form", new ChangePasswordDTO());
            return "change-password";
        }


        return "reset-password-error";
    }

   //TODO ZROBIC POSTMAPPING DO RESET

    public boolean checkPasswordsEquality(ChangePasswordDTO form) {
        return form.getPassword().equals(form.getConfirmedPassword());
    }





    public boolean checkIsEmailInDatabase(String email) {
        UserDTO userDTO = userService.findUserByEmail(email);

        if (userDTO == null) {
            return false;
        }

        return true;
    }



}
