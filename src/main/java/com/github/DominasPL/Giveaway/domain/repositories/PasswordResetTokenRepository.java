package com.github.DominasPL.Giveaway.domain.repositories;

import com.github.DominasPL.Giveaway.domain.entities.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {


    PasswordResetToken findByPasswordResetToken(String passwordResetToken);
}
