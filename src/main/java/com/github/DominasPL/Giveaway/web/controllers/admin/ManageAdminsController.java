package com.github.DominasPL.Giveaway.web.controllers.admin;

import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.dtos.*;
import com.github.DominasPL.Giveaway.services.InstitutionService;
import com.github.DominasPL.Giveaway.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin/panel/admins")
public class ManageAdminsController {

    private UserService userService;


    public ManageAdminsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayAdmins(Model model) {

        List<AdminUserDTO> admins = userService.loadAllAdmins();

        model.addAttribute("admins", admins);

        return "display-admins";
    }

    @GetMapping("/add")
    public String addAdminPrepareForm(Model model) {

        model.addAttribute("form", new RegistrationFormDTO());

        return "add-admin";
    }

    @PostMapping("/add")
    public String addAdmin(@Valid @ModelAttribute("form") RegistrationFormDTO form, BindingResult result) {

        if (result.hasErrors()) {
            return "add-admin";
        }

        if (!checkPasswordsEquality(form)) {
            result.rejectValue("password", null, "Hasła nie są zgodne.");
            return "registration-form";
        }

        if (!checkEmailIsAvailable(form)) {
            result.rejectValue("email", null, "Email zajęty.");
            return "registration-form";
        }

        userService.addAdmin(form);

        return "redirect:/admin/panel/admins";

    }

    @GetMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable("id") Long id) {

        userService.deleteUser(id);

        return "redirect:/admin/panel/admins";
    }

    @GetMapping("/edit/{id}")
    public String editAdminForm(@PathVariable("id") Long id, Model model) {

        UserDTO userDTO = userService.findUserById(id);

        EditUserDTO editUserDTO = new EditUserDTO();
        editUserDTO.setEmail(userDTO.getEmail());
        editUserDTO.setFirstName(userDTO.getFirstName());
        editUserDTO.setLastName(userDTO.getLastName());
        editUserDTO.setPhoneNumber(userDTO.getPhoneNumber());
        editUserDTO.setPostalCode(userDTO.getPostalCode());
        editUserDTO.setStreet(userDTO.getStreet());
        editUserDTO.setStreetNumber(userDTO.getStreetNumber());
        editUserDTO.setRole(userDTO.getRole());
        editUserDTO.setActive(userDTO.getActive());

        model.addAttribute("form", editUserDTO);

        return "edit-details";
    }

    @PostMapping("/edit/{id}")
    public String editAdmin(@RequestParam("active") Boolean active, @PathVariable("id") Long id, @Valid @ModelAttribute("form") EditUserDTO form, BindingResult result) {

        if (result.hasErrors()) {
            return "edit-details";
        }

        userService.editUserDetailsAdminPanel(form, id, active);

        //TODO WYSWIETLIC KOMUNIKAT PO POPRAWNEJ EDYCJI DANYCH

        return "redirect:/admin/panel/admins/edit/"+ id;

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



//
//    @GetMapping("/institutions")
//    public String displayInstitutions(Model model) {
//
//        List<InstitutionDTO> institutionsDTO = institutionService.loadAllInstitutions();
//
//        model.addAttribute("institutions", institutionsDTO);
//
//        return "display-institutions";
//
//    }


}
