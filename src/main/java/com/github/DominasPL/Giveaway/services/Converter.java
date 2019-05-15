package com.github.DominasPL.Giveaway.services;

import com.github.DominasPL.Giveaway.domain.entities.Institution;
import com.github.DominasPL.Giveaway.domain.entities.Role;
import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.dtos.AdminUserDTO;
import com.github.DominasPL.Giveaway.dtos.InstitutionDTO;
import com.github.DominasPL.Giveaway.dtos.RegistrationFormDTO;

import java.util.ArrayList;
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

    public static List<AdminUserDTO> convertToAdminUserDTO(List<User> allAdmins) {
        List<AdminUserDTO> adminsOrUsersDTO = new ArrayList<>();
        for (User user: allAdmins) {
            AdminUserDTO adminDTO = new AdminUserDTO();
            adminDTO.setEmail(user.getEmail());
            adminsOrUsersDTO.add(adminDTO);
        }

        return adminsOrUsersDTO;
    }

    public static List<InstitutionDTO> convertToInstitutionDTO(List<Institution> allInstitutions) {
        List<InstitutionDTO> institutionsDTO = new ArrayList<>();
        for (Institution institution: allInstitutions) {
            InstitutionDTO institutionDTO = new InstitutionDTO();
            institutionDTO.setName(institution.getName());
            institutionsDTO.add(institutionDTO);
        }

        return institutionsDTO;
    }
}
