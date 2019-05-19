package com.github.DominasPL.Giveaway.web.controllers.admin;

import com.github.DominasPL.Giveaway.dtos.AdminUserDTO;
import com.github.DominasPL.Giveaway.dtos.EditUserDTO;
import com.github.DominasPL.Giveaway.dtos.RegistrationFormDTO;
import com.github.DominasPL.Giveaway.dtos.UserDTO;
import com.github.DominasPL.Giveaway.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/panel/users")
public class ManageUsersController {

    private UserService userService;

    public ManageUsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String displayUsers(Model model) {

        List<AdminUserDTO> users = userService.loadAllUsers();

        model.addAttribute("users", users);

        return "display-users";

    }

    @GetMapping("/add")
    public String addUserPrepareForm(Model model) {


        model.addAttribute("form", new RegistrationFormDTO());

        return "add-user";

    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute("form") RegistrationFormDTO form, BindingResult result) {

        if (result.hasErrors()) {
            return "add-user";
        }

        if (!checkPasswordsEquality(form)) {
            result.rejectValue("password", null, "Hasła nie są zgodne.");
            return "registration-form";
        }

        if (!checkEmailIsAvailable(form)) {
            result.rejectValue("email", null, "Email zajęty.");
            return "registration-form";
        }

        userService.registerUser(form);

        return "redirect:/admin/panel/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {

        userService.deleteUser(id);

        return "redirect:/admin/panel/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") Long id, Model model) {

        UserDTO userDTO = userService.findUserById(id);

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

    @PostMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, @Valid @ModelAttribute("form") EditUserDTO form, BindingResult result) {

        if (result.hasErrors()) {
            return "edit-details";
        }

        userService.editUserDetailsAdminPanel(form, id);

        //TODO WYSWIETLIC KOMUNIKAT PO POPRAWNEJ EDYCJI DANYCH

        return "redirect:/admin/panel/users/edit/"+ id;

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



}
