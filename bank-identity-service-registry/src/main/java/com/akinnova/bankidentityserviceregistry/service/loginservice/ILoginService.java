package com.akinnova.bankidentityserviceregistry.service.loginservice;

import com.akinnova.bankidentityserviceregistry.dto.logindto.LoginDto;
import org.springframework.http.ResponseEntity;

public interface ILoginService {
    ResponseEntity<?> login(LoginDto loginDto);
    ResponseEntity<?> userLoggedIn(String email);
}
