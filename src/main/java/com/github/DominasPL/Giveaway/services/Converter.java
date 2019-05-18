package com.github.DominasPL.Giveaway.services;

import com.github.DominasPL.Giveaway.domain.entities.Institution;
import com.github.DominasPL.Giveaway.domain.entities.Role;
import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.dtos.*;

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

    public static UserNameAndRoleDTO convertToUserNameAndRoleDTO(User user) {
        UserNameAndRoleDTO userDTO = new UserNameAndRoleDTO();
        userDTO.setFirstName(user.getUserDetails().getFirstName());
        userDTO.setRole(user.getRoles().get(0).getRole());

        return userDTO;

    }

    public static UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getUserDetails().getFirstName());
        userDTO.setLastName(user.getUserDetails().getLastName());
        userDTO.setPhoneNumber(user.getUserDetails().getPhoneNumber());
        userDTO.setStreet(user.getUserDetails().getStreet());
        userDTO.setStreetNumber(user.getUserDetails().getStreetNumber());
        userDTO.setPostalCode(user.getUserDetails().getPostalCode());

        return userDTO;
    }

    public static User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());

        return user;
    }
}
