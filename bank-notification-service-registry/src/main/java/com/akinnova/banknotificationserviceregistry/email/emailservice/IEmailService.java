package com.akinnova.banknotificationserviceregistry.email.emailservice;

import com.akinnova.banknotificationserviceregistry.email.emaildto.EmailDetail;
import org.springframework.http.ResponseEntity;

public interface IEmailService {
    ResponseEntity<?> sendSimpleEmail(EmailDetail emailDetail);
    ResponseEntity<?> sendEmailWithAttachment(EmailDetail emailDetail);
}
