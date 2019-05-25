package com.github.DominasPL.Giveaway.domain.repositories;

import com.github.DominasPL.Giveaway.domain.entities.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GiftRepository extends JpaRepository<Gift, Long> {

    @Query(value = "SELECT * FROM gifts\n" +
            "ORDER BY created DESC\n" +
            "LIMIT 1;", nativeQuery = true)
    Optional<Gift> findLastGift();

}
