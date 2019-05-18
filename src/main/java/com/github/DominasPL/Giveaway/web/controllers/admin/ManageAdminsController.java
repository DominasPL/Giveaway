package com.github.DominasPL.Giveaway.web.controllers.admin;

import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.dtos.AdminUserDTO;
import com.github.DominasPL.Giveaway.dtos.InstitutionDTO;
import com.github.DominasPL.Giveaway.dtos.RegistrationFormDTO;
import com.github.DominasPL.Giveaway.dtos.UserDTO;
import com.github.DominasPL.Giveaway.services.InstitutionService;
import com.github.DominasPL.Giveaway.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

        List<AdminUserDTO> adminsDTO = userService.loadAllAdmins();

        model.addAttribute("admins", adminsDTO);

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

    @GetMapping("/delete/{admin-email}")
    public String deleteAdmin(@PathVariable("admin-email") String email) {

        userService.deleteUser(email);

        return "redirect:/admin/panel/admins";
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



//    @GetMapping("/users")
//    public String displayUsers(Model model) {
//
//        List<AdminUserDTO> usersDTO = userService.loadAllUsers();
//
//        model.addAttribute("users", usersDTO);
//
//        return "display-users";
//
//    }
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
