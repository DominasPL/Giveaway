package com.github.DominasPL.Giveaway.services;


import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.domain.repositories.UserRepository;
import com.github.DominasPL.Giveaway.dtos.RegistrationFormDTO;
import com.github.DominasPL.Giveaway.web.controllers.RegistrationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findUserByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email musi byc podany.");
        }

        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = optionalUser.orElse(null);

        if (user == null) {
            logger.debug("Nie znaleziono użytkownika.");
            return null;
        }

        return user;

    }

    @Transactional
    public void registerUser(RegistrationFormDTO form) {

        User user = Converter.coonvertToUser(form);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }
}
