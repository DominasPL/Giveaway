package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.domain.entities.Gift;
import com.github.DominasPL.Giveaway.domain.entities.Institution;
import com.github.DominasPL.Giveaway.domain.entities.Location;
import com.github.DominasPL.Giveaway.domain.repositories.GiftRepository;
import com.github.DominasPL.Giveaway.domain.repositories.UserRepository;
import com.github.DominasPL.Giveaway.dtos.GiftDTO;
import com.github.DominasPL.Giveaway.dtos.InstitutionDTO;
import com.github.DominasPL.Giveaway.dtos.UserDTO;
import com.github.DominasPL.Giveaway.services.InstitutionService;
import com.github.DominasPL.Giveaway.services.LocationService;
import com.github.DominasPL.Giveaway.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/gift")
public class GiftFormController {

    private static final Logger logger = LoggerFactory.getLogger(GiftFormController.class);

    private UserService userService;
    private LocationService locationService;
    private InstitutionService institutionService;

    public GiftFormController(UserService userService, LocationService locationService, InstitutionService institutionService) {
        this.userService = userService;
        this.locationService = locationService;
        this.institutionService = institutionService;
    }

    @GetMapping
    public String displayGiftForm(Model model) {

        model.addAttribute("answers", new GiftDTO());

        return "test-form";
    }

    @PostMapping
    public String saveGift(Principal principal, @ModelAttribute("answers") GiftDTO things) {

        userService.saveGift(principal, things);
        //TODO ZAMIENIC USERSERVICE NA GIFTSERVICE

        return "redirect:/";
    }

    @ModelAttribute("locations")
    public List<Location> getLocations() {

        //TODO ZROBIC DTO CZY NIE?
        return locationService.getLocations();
    }

    @ModelAttribute("institutions")
    public List<InstitutionDTO> getInstitutions() {

        return institutionService.loadAllInstitutions();
    }



}
