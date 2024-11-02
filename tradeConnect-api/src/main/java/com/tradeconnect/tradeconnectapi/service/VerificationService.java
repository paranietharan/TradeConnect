package com.tradeconnect.tradeconnectapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class VerificationService {

    @Autowired
    private JavaMailSender mailSender;

    private final Random random = new Random();

    public String generateVerificationPin() {
        int pin = 100000 + random.nextInt(900000);
        return String.valueOf(pin);
    }

    public void sendVerificationEmail(String email, String pin){
        try{
            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(email);
            mailMessage.setSubject("TradeConnect Email Verification");
            mailMessage.setText("Your verification pin is: " + pin);
            mailSender.send(mailMessage);
        } catch (Exception e) {
            System.out.println("Failed to send verification email to: " + email);
        }

        // print the verification pin & email to the console
        System.out.println("Verification email sent to: " + email);
        System.out.println("Verification pin: " + pin);
    }
}