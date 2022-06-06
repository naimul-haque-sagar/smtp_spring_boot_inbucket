package com;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/send")
    public void send() throws MessagingException {
        this.emailService.sendEmail();
    }

}
