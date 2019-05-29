package com.github.DominasPL.Giveaway.web.controllers.admin;

import com.github.DominasPL.Giveaway.dtos.*;
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

        String check = "users";
        UserDTO userDTO = userService.findUserById(id);

        EditUserDTO editUserDTO = new EditUserDTO();
        editUserDTO.setEmail(userDTO.getEmail());
        editUserDTO.setFirstName(userDTO.getFirstName());
        editUserDTO.setLastName(userDTO.getLastName());
        editUserDTO.setPhoneNumber(userDTO.getPhoneNumber());
        editUserDTO.setPostalCode(userDTO.getPostalCode());
        editUserDTO.setStreet(userDTO.getStreet());
        editUserDTO.setStreetNumber(userDTO.getStreetNumber());
        editUserDTO.setActive(userDTO.getActive());

        model.addAttribute("id", id);
        model.addAttribute("check", check);
        model.addAttribute("form", editUserDTO);

        return "edit-details";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@RequestParam("active") Boolean active , @PathVariable("id") Long id, @Valid @ModelAttribute("form") EditUserDTO form, BindingResult result) {

        if (result.hasErrors()) {
            return "edit-details";
        }

        userService.editUserDetailsAdminPanel(form, id, active);

        //TODO WYSWIETLIC KOMUNIKAT PO POPRAWNEJ EDYCJI DANYCH

        return "redirect:/admin/panel/users/edit/"+ id;

    }

    @GetMapping("/edit/{id}/change-password")
    public String displayForm(@PathVariable("id") Long id, Model model) {


        model.addAttribute("form", new ChangePasswordDTO());

        return "change-password";

    }

    @PostMapping("/edit/{id}/change-password")
    public String changeUserPassword(@PathVariable("id") Long id, @Valid @ModelAttribute("form") ChangePasswordDTO form, BindingResult result) {

        if (result.hasErrors()) {
            return "change-password";
        }

        if (!checkPasswordsEquality(form)) {
            result.rejectValue("password", null, "Hasła są niezgodne");
            return "change-password";
        }

        userService.changePassword(id, form);

        return "redirect:/admin/panel/users";

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

    public boolean checkPasswordsEquality(ChangePasswordDTO form) {
        return form.getPassword().equals(form.getConfirmedPassword());
    }


}
