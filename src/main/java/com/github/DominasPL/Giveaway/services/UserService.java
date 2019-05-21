package com.github.DominasPL.Giveaway.services;


import com.github.DominasPL.Giveaway.domain.entities.*;
import com.github.DominasPL.Giveaway.domain.repositories.GiftRepository;
import com.github.DominasPL.Giveaway.domain.repositories.InstitutionRepository;
import com.github.DominasPL.Giveaway.domain.repositories.ThingRepository;
import com.github.DominasPL.Giveaway.domain.repositories.UserRepository;
import com.github.DominasPL.Giveaway.dtos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.net.www.content.image.gif;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;
    private InstitutionRepository institutionRepository;
    private GiftRepository giftRepository;
    private ThingRepository thingRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleService roleService, InstitutionRepository institutionRepository, GiftRepository giftRepository, ThingRepository thingRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.institutionRepository = institutionRepository;
        this.giftRepository = giftRepository;
        this.thingRepository = thingRepository;
    }

    @Transactional
    public void registerUser(RegistrationFormDTO form) {

        Role userRole = roleService.findUserRole();
        User user = Converter.convertToUser(form, userRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        UserDetails userDetails = new UserDetails();
        userDetails.setId(user.getId());
        userDetails.setFirstName("");
        user.setUserDetails(userDetails);
        userRepository.save(user);

    }

    @Transactional
    public void addAdmin(RegistrationFormDTO form) {

        Role adminRole = roleService.findAdminRole();
        User user = Converter.convertToUser(form, adminRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        UserDetails userDetails = new UserDetails();
        userDetails.setId(user.getId());
        userDetails.setFirstName("");
        user.setUserDetails(userDetails);
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User admin = optionalUser.orElse(null);
        userRepository.delete(admin);
    }


    @Transactional
    public void editUserDetails(EditUserDTO form) {

        Optional<User> optionalUser = userRepository.findByEmail(form.getEmail());
        User user = optionalUser.orElse(null);
        User editedUser = Converter.addUserPersonalDetails(form, user);
        userRepository.save(editedUser);
    }

    @Transactional
    public void editUserDetailsAdminPanel(EditUserDTO form, Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElse(null);
        User editedUser = Converter.addUserPersonalDetails(form, user);
        userRepository.save(editedUser);

    }

    @Transactional
    public void saveGift(Principal principal, GiftDTO giftDTO) {

        Optional<User> optionalUser = userRepository.findByEmail(principal.getName());
        User user = optionalUser.orElse(null);
        List<Institution> institutions = institutionRepository.findAll();
        List<Gift> gifts = user.getGifts();
        Gift gift = new Gift();
        gift.setAmount(giftDTO.getAmount());
        gift.setLocation(giftDTO.getLocation());
        gift.setInstitution(giftDTO.getInstitution());

        //TODO USTAWIĆ ADRES ORAZ TERMIN PRZED ZAPISEM


        List<Group> groups = gift.getGroups();
        for (String value: giftDTO.getGroups()) {
            Group group = new Group();
            group.setName(value);
            groups.add(group);
        }

        List<Thing> things = gift.getThings();
        for (String value: giftDTO.getThings()) {
            Thing thing = new Thing();
            thing.setName(value);
            things.add(thing);
        }

        gifts.add(gift);

    }

    public UserDTO findUserByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email musi byc podany.");
        }

        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = optionalUser.orElse(null);

        if (user == null) {
            logger.debug("Nie znaleziono użytkownika.");
            return null;
        }

        UserDTO userDTO = Converter.convertToUserDTO(user);

        return userDTO;
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


    public UserNameAndRoleDTO findUserNameAndRole(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email musi byc podany.");
        }

        Optional<User> optionalUser = userRepository.findByEmail(email);
        User user = optionalUser.orElse(null);

        if (user == null) {
            logger.debug("Nie znaleziono użytkownika.");
            return null;
        }

        UserNameAndRoleDTO userDTO = Converter.convertToUserNameAndRoleDTO(user);

        return userDTO;

    }


    public UserDTO findUserById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id musi byc podane.");
        }

        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElse(null);

        if (user == null) {
            return null;
        }

        UserDTO userDTO = Converter.convertToUserDTO(user);

        return userDTO;

    }


}
