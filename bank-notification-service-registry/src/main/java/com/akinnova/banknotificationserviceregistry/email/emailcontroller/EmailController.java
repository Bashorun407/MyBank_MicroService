package com.akinnova.banknotificationserviceregistry.email.emailcontroller;

import com.akinnova.banknotificationserviceregistry.email.emaildto.EmailDetail;
import com.akinnova.banknotificationserviceregistry.email.emailservice.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/email/auth")
public class EmailController {
    @Autowired
    private EmailService emailService;

    //1) Method to send simple mail
    @PostMapping("/simpleMail")
    public ResponseEntity<?> sendSimpleEmail(@RequestBody EmailDetail emailDetail) {
        return emailService.sendSimpleEmail(emailDetail);
    }

    //2) Method to send mail with attachment
    @PostMapping("auth/mailWithAttachment")
    public ResponseEntity<?> sendEmailWithAttachment(@RequestBody EmailDetail emailDetail) {
        return emailService.sendEmailWithAttachment(emailDetail);
    }
}
