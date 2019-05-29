package com.github.DominasPL.Giveaway.services;

import com.github.DominasPL.Giveaway.domain.entities.*;
import com.github.DominasPL.Giveaway.dtos.*;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static User convertToUser(RegistrationFormDTO form, Role userRole) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setActive(true);
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
        userDTO.setActive(user.getActive());

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
        userDTO.setActive(user.getActive());

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

    public static List<GiftDTO> convertToGiftDTO(List<Gift> gifts) {

        List<GiftDTO> giftsDTO = new ArrayList<>();

        for (Gift gift: gifts) {
            GiftDTO giftDTO = new GiftDTO();
            giftDTO.setAmount(gift.getAmount());
            giftDTO.setInstitution(gift.getInstitution());
            giftDTO.setLocation(gift.getLocation());
            giftDTO.setStreet(gift.getAddress().getStreet());
            giftDTO.setPostalCode(gift.getAddress().getPostalCode());
            giftDTO.setTown(gift.getAddress().getTown());
            giftDTO.setPhoneNumber(gift.getAddress().getPhoneNumber());
            giftDTO.setCreated(gift.getCreated());
            giftDTO.setTaken(gift.getTaken());

            List<String> giftDTOGroups = new ArrayList<>();
            List<Group> giftGroups = gift.getGroups();

            for (Group group: giftGroups) {
                String name = group.getName();
                giftDTOGroups.add(name);
            }
            giftDTO.setGroups(giftDTOGroups);

            List<String> giftDTOThings = new ArrayList<>();
            List<Thing> giftThings = gift.getThings();

            for (Thing thing: giftThings) {
                String name = thing.getName();
                giftDTOThings.add(name);
            }
            giftDTO.setThings(giftDTOThings);

            giftsDTO.add(giftDTO);

        }

        return giftsDTO;


    }

    public static List<UserGiftDTO> convertToUserGiftDTO(UserDTOWithGifts userDTOWithGifts) {

        List<UserGiftDTO> userGiftDTOS = new ArrayList<>();
        for (Gift gift:userDTOWithGifts.getGifts()) {

            UserGiftDTO userGiftDTO = new UserGiftDTO();
            userGiftDTO.setId(gift.getId());
            userGiftDTO.setAmount(gift.getAmount());
            userGiftDTO.setInstitution(gift.getInstitution().getName());
            userGiftDTOS.add(userGiftDTO);
        }

        return userGiftDTOS;

    }

    public static UserDTOWithGifts convertToUserDTOWithGifts(User user) {

        UserDTOWithGifts userDTOWithGifts = new UserDTOWithGifts();
        userDTOWithGifts.setGifts(user.getGifts());

        return userDTOWithGifts;
    }

    public static GiftDTO convertToGiftDTO(Gift gift) {

        GiftDTO giftDTO = new GiftDTO();
        giftDTO.setAmount(gift.getAmount());
        giftDTO.setLocation(gift.getLocation());
        giftDTO.setInstitution(gift.getInstitution());
        giftDTO.setStreet(gift.getAddress().getStreet());
        giftDTO.setTown(gift.getAddress().getTown());
        giftDTO.setPostalCode(gift.getAddress().getPostalCode());
        giftDTO.setPhoneNumber(gift.getAddress().getPhoneNumber());
        giftDTO.setComment(gift.getComment());
        giftDTO.setCreated(gift.getCreated());
        giftDTO.setTaken(gift.getTaken());

        List<String> groupsName = new ArrayList<>();

        for (Group group:gift.getGroups()) {
            String name = group.getName();
            groupsName.add(name);
        }

        giftDTO.setGroups(groupsName);

        List<String> thingsName = new ArrayList<>();

        for (Thing thing:gift.getThings()) {
            String name = thing.getName();
            thingsName.add(name);
        }

        giftDTO.setThings(thingsName);

        return giftDTO;

    }
}
