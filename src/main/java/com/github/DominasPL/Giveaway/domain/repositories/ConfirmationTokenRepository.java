package com.github.DominasPL.Giveaway.domain.repositories;

import com.github.DominasPL.Giveaway.domain.entities.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {


    ConfirmationToken findByConfirmationToken(String confirmationToken);

    @Query(value = "SELECT * FROM confirmation_token WHERE user_id = ?1", nativeQuery = true)
    Optional<ConfirmationToken> findByUserId(Long id);
}
