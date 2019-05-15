package com.github.DominasPL.Giveaway.web.controllers;

import com.github.DominasPL.Giveaway.dtos.AdminUserDTO;
import com.github.DominasPL.Giveaway.dtos.InstitutionDTO;
import com.github.DominasPL.Giveaway.services.InstitutionService;
import com.github.DominasPL.Giveaway.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/login/admin")
public class AdminController {

    private UserService userService;

    private InstitutionService institutionService;

    public AdminController(UserService userService, InstitutionService institutionService) {
        this.userService = userService;
        this.institutionService = institutionService;
    }

    @GetMapping("/admins")
    public String displayAdmins(Model model) {

        List<AdminUserDTO> adminsDTO = userService.loadAllAdmins();

        model.addAttribute("admins", adminsDTO);

        return "display-admins";
    }

    @GetMapping("/users")
    public String displayUsers(Model model) {

        List<AdminUserDTO> usersDTO = userService.loadAllUsers();

        model.addAttribute("users", usersDTO);

        return "display-users";

    }

    @GetMapping("/institutions")
    public String displayInstitutions(Model model) {

        List<InstitutionDTO> institutionsDTO = institutionService.loadAllInstitutions();

        model.addAttribute("institutions", institutionsDTO);

        return "display-institutions";

    }


}
