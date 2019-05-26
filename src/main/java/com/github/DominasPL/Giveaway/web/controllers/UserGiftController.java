package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.domain.entities.Gift;
import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.domain.repositories.GiftRepository;
import com.github.DominasPL.Giveaway.dtos.UserDTO;
import com.github.DominasPL.Giveaway.dtos.UserGiftDTO;
import com.github.DominasPL.Giveaway.services.GiftService;
import com.github.DominasPL.Giveaway.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/my-gifts")
public class UserGiftController {

    private static final Logger logger = LoggerFactory.getLogger(UserGiftController.class);

    private GiftService giftService;

    public UserGiftController(GiftService giftService) {
        this.giftService = giftService;
    }

    @GetMapping
    public String displayUserGifts(Model model, Principal principal) {

        List<UserGiftDTO> userGifts = giftService.findUserGifts(principal.getName());

        model.addAttribute("gifts", userGifts);

        return "user-gifts";

    }

}
