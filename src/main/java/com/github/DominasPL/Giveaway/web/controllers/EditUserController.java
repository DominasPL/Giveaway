package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.dtos.EditUserDTO;
import com.github.DominasPL.Giveaway.dtos.UserDTO;
import com.github.DominasPL.Giveaway.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/profile")
public class EditUserController {

    private static final Logger logger = LoggerFactory.getLogger(EditUserController.class);

    private UserService userService;

    public EditUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String editPersonalDetailsForm(Principal principal, Model model) {

        UserDTO userDTO = userService.findUserByEmail(principal.getName());

        EditUserDTO editUserDTO = new EditUserDTO();
        editUserDTO.setEmail(userDTO.getEmail());
        editUserDTO.setFirstName(userDTO.getFirstName());
        editUserDTO.setLastName(userDTO.getLastName());
        editUserDTO.setPhoneNumber(userDTO.getPhoneNumber());
        editUserDTO.setPostalCode(userDTO.getPostalCode());
        editUserDTO.setStreet(userDTO.getStreet());
        editUserDTO.setStreetNumber(userDTO.getStreetNumber());

        model.addAttribute("form", editUserDTO);

        return "edit-details";
    }

    @PostMapping
    public String editPersonalDetails(@Valid @ModelAttribute("form") EditUserDTO form, BindingResult result) {

        if (result.hasErrors()) {
            return "edit-details";
        }

        userService.editUserDetails(form);

        //TODO WYSWIETLIC KOMUNIKAT PO POPRAWNEJ EDYCJI DANYCH

        return "redirect:/profile";

    }


}
