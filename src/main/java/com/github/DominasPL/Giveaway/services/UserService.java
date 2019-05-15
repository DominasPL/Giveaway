package com.github.DominasPL.Giveaway.services;


import com.github.DominasPL.Giveaway.domain.entities.Role;
import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.domain.repositories.UserRepository;
import com.github.DominasPL.Giveaway.dtos.AdminUserDTO;
import com.github.DominasPL.Giveaway.dtos.InstitutionDTO;
import com.github.DominasPL.Giveaway.dtos.RegistrationFormDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Transactional
    public void registerUser(RegistrationFormDTO form) {

        Role userRole = roleService.findUserRole();
        User user = Converter.convertToUser(form, userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

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

    public List<AdminUserDTO> loadAllAdmins() {

        List<User> allAdmins = userRepository.findAllAdmins();
        if (allAdmins == null) {
            logger.debug("Nie znaleziono adminów");
            return null;
        }

        List<AdminUserDTO> adminsDTO = Converter.convertToAdminUserDTO(allAdmins);

        return adminsDTO;

    }

    public List<AdminUserDTO> loadAllUsers() {

        List<User> allUsers = userRepository.findAllUsers();
        if (allUsers == null) {
            logger.debug("Nie znaleziono adminów");
            return null;
        }

        List<AdminUserDTO> usersDTO = Converter.convertToAdminUserDTO(allUsers);

        return usersDTO;

    }

}
