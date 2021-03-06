package com.github.DominasPL.Giveaway.services;

import com.github.DominasPL.Giveaway.domain.entities.Gift;
import com.github.DominasPL.Giveaway.domain.repositories.GiftRepository;
import com.github.DominasPL.Giveaway.dtos.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class GiftService {

    private static final Logger logger = LoggerFactory.getLogger(GiftService.class);


    private GiftRepository giftRepository;
    private UserService userService;

    public GiftService(GiftRepository giftRepository, UserService userService) {
        this.giftRepository = giftRepository;
        this.userService = userService;
    }

    @Transactional
    public void editStatus(StatusDTO status) {

        Optional<Gift> optionalGift = giftRepository.findById(status.getId());
        Gift gift = optionalGift.orElse(null);
        gift.setReceived(status.getReceived());
        giftRepository.save(gift);

    }

    public List<GiftDTO> loadAllGifts() {

        List<Gift> gifts = giftRepository.findAll();
        if (gifts == null) {
            logger.debug("Nie znaleziono darów");
            return null;
        }

        List<GiftDTO> giftsDTO = Converter.convertToGiftDTO(gifts);

        return giftsDTO;

    }

    public List<UserGiftDTO> findUserGifts(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email musi być podane");
        }

        UserDTOWithGifts userDTOWithGifts = userService.findUserGiftsOnly(email);

        if (userDTOWithGifts == null) {
            logger.debug("Nie znaleziono uzytkownika");
            return null;
        }

        List<UserGiftDTO> userGiftDTOS = Converter.convertToUserGiftDTO(userDTOWithGifts);


        return userGiftDTOS;

    }

    public GiftDTO findGiftById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Id musi być podane");
        }

        Optional<Gift> optionalGift = giftRepository.findById(id);
        Gift gift = optionalGift.orElse(null);

        if (gift == null) {
            logger.debug("Nie znaelziono daru");
            return null;
        }

        GiftDTO giftDTO = Converter.convertToGiftDTO(gift);

        return giftDTO;

    }

    public Long findGiftId() {

        Optional<Gift> optionalGift = giftRepository.findLastGift();
        Gift gift = optionalGift.orElse(null);

        if (gift == null) {
            logger.debug("Nie znaleziono daru");
            return null;
        }

        return gift.getId();

    }


    public StatusDTO findGiftIdAndStatus(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Id musi być podane");
        }

        Optional<Gift> optionalGift = giftRepository.findById(id);
        Gift gift = optionalGift.orElse(null);

        if (gift == null) {
            logger.debug("Nie znaelziono daru");
            return null;
        }

        StatusDTO statusDTO = Converter.convertToStatusDTO(gift);

        return statusDTO;

    }


}
