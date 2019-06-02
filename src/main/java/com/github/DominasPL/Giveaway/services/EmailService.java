package com.github.DominasPL.Giveaway.services;

import com.github.DominasPL.Giveaway.domain.entities.ConfirmationToken;
import com.github.DominasPL.Giveaway.domain.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(User user, ConfirmationToken token) throws MailException {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setFrom("dominas1212@gmail.com");
        mail.setSubject("Nowa wiadomość ważna");
        mail.setText("To confirm your account please click here: " + "http://localhost:8090/register/confirm-account?token="+token.getConfirmationToken());

        javaMailSender.send(mail);

    }


}
