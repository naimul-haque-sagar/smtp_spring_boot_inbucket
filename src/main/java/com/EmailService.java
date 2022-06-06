package com;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    private final String defaultSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
        this.defaultSender = "no-reply@test.com";
    }

    public void sendEmail() throws MessagingException {
        MimeMessage message = this.mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setFrom(this.defaultSender);
        helper.setTo("developer@test.com");
        helper.setText("<h1>Hello World</h1>", true);
        helper.setSubject("Test Email");

        this.mailSender.send(message);
    }
}
