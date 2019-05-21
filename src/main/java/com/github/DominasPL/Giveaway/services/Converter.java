package com.github.DominasPL.Giveaway.services;

import com.github.DominasPL.Giveaway.domain.entities.Institution;
import com.github.DominasPL.Giveaway.domain.entities.Role;
import com.github.DominasPL.Giveaway.domain.entities.User;
import com.github.DominasPL.Giveaway.domain.entities.UserDetails;
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
            adminDTO.setId(user.getId());
            adminDTO.setEmail(user.getEmail());
            adminsOrUsersDTO.add(adminDTO);
        }

        return adminsOrUsersDTO;
    }

    public static List<InstitutionDTO> convertToInstitutionDTO(List<Institution> allInstitutions) {
        List<InstitutionDTO> institutionsDTO = new ArrayList<>();
        for (Institution institution: allInstitutions) {
            InstitutionDTO institutionDTO = new InstitutionDTO();
            institutionDTO.setId(institution.getId());
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
        userDTO.setRole(user.getRoles().get(0).getRole());

        return userDTO;
    }

    public static User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());

        return user;
    }


    public static User addUserPersonalDetails(EditUserDTO form, User user) {
        UserDetails userDetails = user.getUserDetails();
        userDetails.setFirstName(form.getFirstName());
        userDetails.setLastName(form.getLastName());
        userDetails.setPhoneNumber(form.getPhoneNumber());
        userDetails.setPostalCode(form.getPostalCode());
        userDetails.setStreet(form.getStreet());
        userDetails.setStreetNumber(form.getStreetNumber());

        return user;

    }

    public static Institution convertToInstitution(InstitutionDTO form) {
        Institution institution = new Institution();
        institution.setName(form.getName());

        return institution;
    }

    public static InstitutionDTO convertToInstitutionDTO(Institution institution) {

        InstitutionDTO institutionDTO = new InstitutionDTO();
        institutionDTO.setId(institution.getId());
        institutionDTO.setName(institution.getName());

        return institutionDTO;
    }
}
