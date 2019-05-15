package com.github.DominasPL.Giveaway.domain.repositories;

import com.github.DominasPL.Giveaway.domain.entities.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {

}
