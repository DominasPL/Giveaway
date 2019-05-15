package com.github.DominasPL.Giveaway.services;

import com.github.DominasPL.Giveaway.domain.entities.Institution;
import com.github.DominasPL.Giveaway.domain.repositories.InstitutionRepository;
import com.github.DominasPL.Giveaway.dtos.AdminUserDTO;
import com.github.DominasPL.Giveaway.dtos.InstitutionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstitutionService {

    private static final Logger logger = LoggerFactory.getLogger(InstitutionService.class);

    private InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }


    public List<InstitutionDTO> loadAllInstitutions() {

        List<Institution> allInstitutions = institutionRepository.findAll();
        if (allInstitutions == null) {
            logger.debug("Nie znaleziono adminów");
            return null;
        }

        List<InstitutionDTO> institutionsDTO = Converter.convertToInstitutionDTO(allInstitutions);

        return institutionsDTO;

    }
}
