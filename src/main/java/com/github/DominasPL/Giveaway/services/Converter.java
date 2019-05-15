package com.github.DominasPL.Giveaway.services;

import com.github.DominasPL.Giveaway.domain.entities.Role;
import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.dtos.RegistrationFormDTO;

import java.util.List;

public class Converter {

    public static User convertToUser(RegistrationFormDTO form, Role userRole) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        List<Role> roles = user.getRoles();
        roles.add(userRole);
        return user;
    }
}
