package com.cfs.Payment_Gateway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String toEmail, String name, double amount){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject("Email Sending Program completed by rohit");
        mailMessage.setText("Hi "+name+". \n\n" +
                "you have successfully paid "+amount+" " +
                "Rs payment for my service on my website. \n\n" +
                "This email is sent by Rohit for practice & testing purpose" +
                "of his email and payment application ");
        javaMailSender.send(mailMessage);
    }
}
