package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.dtos.EditUserDTO;
import com.github.DominasPL.Giveaway.dtos.UserDTO;
import com.github.DominasPL.Giveaway.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
public class UserProfileController {

    private static final Logger logger = LoggerFactory.getLogger(UserProfileController.class);

    private UserService userService;

    public UserProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String editPersonalDetails(Principal principal, Model model) {

        UserDTO userDTO = userService.findUserByEmail(principal.getName());
        logger.info(userDTO.toString());

        EditUserDTO editUserDTO = new EditUserDTO();
        editUserDTO.setFirstName(userDTO.getFirstName());
        editUserDTO.setLastName(userDTO.getLastName());
        editUserDTO.setPhoneNumber(userDTO.getPhoneNumber());
        editUserDTO.setPostalCode(userDTO.getPostalCode());
        editUserDTO.setStreet(userDTO.getStreet());
        editUserDTO.setStreetNumber(userDTO.getStreetNumber());

        model.addAttribute("form", editUserDTO);

        return "edit-details";
    }


}
