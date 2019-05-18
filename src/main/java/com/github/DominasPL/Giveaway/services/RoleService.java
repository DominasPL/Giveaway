package com.github.DominasPL.Giveaway.services;

import com.github.DominasPL.Giveaway.domain.entities.Role;
import com.github.DominasPL.Giveaway.domain.repositories.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleService.class);

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findUserRole() {

        Optional<Role> optionalRole = roleRepository.findByRole("ROLE_USER");
        Role role = optionalRole.orElse(null);

        if (role == null) {
            logger.debug("Nie znaleziono roli");
            return null;
        }

        return role;

    }

    public Role findAdminRole() {
        Optional<Role> optionalRole = roleRepository.findByRole("ROLE_ADMIN");
        Role role = optionalRole.orElse(null);

        if (role == null) {
            logger.debug("Nie znaleziono roli");
            return null;
        }

        return role;
    }
}
