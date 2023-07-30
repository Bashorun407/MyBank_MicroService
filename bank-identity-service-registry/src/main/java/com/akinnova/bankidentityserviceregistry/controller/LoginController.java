package com.akinnova.bankidentityserviceregistry.controller;

import com.akinnova.bankidentityserviceregistry.dto.logindto.LoginDto;
import com.akinnova.bankidentityserviceregistry.service.loginservice.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/login/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        return loginService.login(loginDto);
    }

    @GetMapping("/login/{email}")
    public ResponseEntity<?> userLoggedIn(@PathVariable String email) {
        return loginService.userLoggedIn(email);
    }
}
