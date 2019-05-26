package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.domain.entities.Location;
import com.github.DominasPL.Giveaway.dtos.GiftDTO;
import com.github.DominasPL.Giveaway.dtos.InstitutionDTO;
import com.github.DominasPL.Giveaway.dtos.SummaryDTO;
import com.github.DominasPL.Giveaway.services.InstitutionService;
import com.github.DominasPL.Giveaway.services.LocationService;
import com.github.DominasPL.Giveaway.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

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
    public String saveGift(Principal principal, @ModelAttribute("answers") GiftDTO things, @RequestParam("date") String date, @RequestParam("time") String time) {

        userService.saveGift(principal, things, date, time);


        InstitutionDTO institutionById = institutionService.findInstitutionById(things.getInstitution().getId());

        //TODO ZAMIENIC USERSERVICE NA GIFTSERVICE

        return "redirect:/gift/summary/"
                +things.getAmount()+"/"
                +institutionById.getName()+"/"
                +things.getStreet()+"/"
                +things.getTown()+"/"
                +things.getPostalCode()+"/"
                +things.getPhoneNumber()+"/"
                +date+"/"
                +time+"/"
                +things.getComment();
    }

    @GetMapping("/summary/{amount}/{name}/{street}/{town}/{postalCode}/{phoneNumber}/{date}/{time}/{comment}")
    public String displaySummary(@PathVariable("amount") Long amount,
                                 @PathVariable("name") String name,
                                 @PathVariable("street") String street,
                                 @PathVariable("town") String town,
                                 @PathVariable("postalCode") String postalCode,
                                 @PathVariable("phoneNumber") String phoneNumber,
                                 @PathVariable("date") String date,
                                 @PathVariable("time") String time,
                                 @PathVariable("comment") String comment, Model model) {

        SummaryDTO summaryDTO = new SummaryDTO();
        summaryDTO.setAmount(amount);
        summaryDTO.setName(name);
        summaryDTO.setStreet(street);
        summaryDTO.setTown(town);
        summaryDTO.setPostalCode(postalCode);
        summaryDTO.setPhoneNumber(phoneNumber);
        summaryDTO.setDate(date);
        summaryDTO.setTime(time);
        summaryDTO.setComment(comment);

        //TODO polskie znaki url

        model.addAttribute("summary", summaryDTO);

        return "summary";

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
