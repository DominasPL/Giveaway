package com.github.DominasPL.Giveaway.services;

import com.github.DominasPL.Giveaway.domain.entities.Gift;
import com.github.DominasPL.Giveaway.domain.repositories.GiftRepository;
import com.github.DominasPL.Giveaway.dtos.GiftDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftService {

    private static final Logger logger = LoggerFactory.getLogger(GiftService.class);


    private GiftRepository giftRepository;

    public GiftService(GiftRepository giftRepository) {
        this.giftRepository = giftRepository;
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

}
