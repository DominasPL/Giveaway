package com.github.DominasPL.Giveaway.services;

import com.github.DominasPL.Giveaway.domain.entities.Institution;
import com.github.DominasPL.Giveaway.domain.repositories.InstitutionRepository;
import com.github.DominasPL.Giveaway.dtos.AdminUserDTO;
import com.github.DominasPL.Giveaway.dtos.InstitutionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InstitutionService {

    private static final Logger logger = LoggerFactory.getLogger(InstitutionService.class);

    private InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Transactional
    public void addInstitution(InstitutionDTO form) {

        Institution institution = Converter.convertToInstitution(form);
        institutionRepository.save(institution);

    }


    @Transactional
    public void deleteInstitution(Long id) {

        Optional<Institution> optionalInstitution = institutionRepository.findById(id);
        Institution institution = optionalInstitution.orElse(null);
        institutionRepository.delete(institution);

    }


    @Transactional
    public void editInstitution(InstitutionDTO form) {

        Optional<Institution> optionalInstitution = institutionRepository.findById(form.getId());
        Institution institution = optionalInstitution.orElse(null);
        institution.setName(form.getName());
        institutionRepository.save(institution);
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

    public InstitutionDTO findInstitutionById(Long id) {

        if (id == null) {
            throw new IllegalArgumentException("Id musi być podane.");
        }

        Optional<Institution> optionalInstitution = institutionRepository.findById(id);

        Institution institution = optionalInstitution.orElse(null);

        if (institution == null) {
            logger.debug("Nie znaleziono instytucji o id = " + id);
            return null;
        }

        InstitutionDTO institutionDTO = Converter.convertToInstitutionDTO(institution);

        return institutionDTO;

    }


}
