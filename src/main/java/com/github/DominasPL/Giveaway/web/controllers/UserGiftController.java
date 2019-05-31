package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.dtos.GiftDTO;
import com.github.DominasPL.Giveaway.dtos.StatusDTO;
import com.github.DominasPL.Giveaway.dtos.UserGiftDTO;
import com.github.DominasPL.Giveaway.services.GiftService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        Collections.sort(userGifts, new Comparator<UserGiftDTO>() {
            public int compare(UserGiftDTO o1, UserGiftDTO o2) {
                return o2.getCreated().compareTo(o1.getCreated());
            }
        });

        model.addAttribute("gifts", userGifts);

        return "user-gifts";

    }

    @GetMapping("/{id}")
    public String displayGiftDetails(@PathVariable("id") Long id, Model model) {

        GiftDTO giftDTO = giftService.findGiftById(id);

        model.addAttribute("gift", giftDTO);

        return "gift-details";

    }

    @GetMapping("/{id}/change-status")
    public String displayStatusForm(@PathVariable("id") Long id, Model model) {

        StatusDTO statusDTO = giftService.findGiftIdAndStatus(id);

        model.addAttribute("status", statusDTO);

        return "status-form";

    }

    @PostMapping("/{id}/change-status")
    public String saveStatus(@Valid @ModelAttribute("status") StatusDTO status, @PathVariable("id") Long id, BindingResult result) {

        if (result.hasErrors()) {
            return "status-form";
        }

        giftService.editStatus(status);

        return "redirect:/my-gifts";

    }

}
