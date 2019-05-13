package com.github.DominasPL.Giveaway.services;

import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.dtos.RegistrationFormDTO;

public class Converter {

    public static User coonvertToUser(RegistrationFormDTO form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        return user;
    }
}
