package com.github.DominasPL.Giveaway.web.controllers.admin;

import com.github.DominasPL.Giveaway.dtos.GiftDTO;
import com.github.DominasPL.Giveaway.services.GiftService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/panel/gifts")
public class ManageGiftsController {

    private GiftService giftServive;

    public ManageGiftsController(GiftService giftServive) {
        this.giftServive = giftServive;
    }

    @GetMapping
    public String displayGifts(Model model) {

        List<GiftDTO> giftsDTO = giftServive.loadAllGifts();

        model.addAttribute("gifts", giftsDTO);

        return "display-gifts";
    }

}
