package com.akinnova.bankidentityserviceregistry.service.loginservice;

import com.akinnova.bankidentityserviceregistry.dto.logindto.LoginDto;
import com.akinnova.bankidentityserviceregistry.entity.UserLogin;
import com.akinnova.bankidentityserviceregistry.exception.ApiException;
import com.akinnova.bankidentityserviceregistry.repository.LoginRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements ILoginService {

    private  final LoginRepository loginRepository;
    private final AuthenticationManager authenticationManager;

    public LoginService(LoginRepository loginRepository, AuthenticationManager authenticationManager) {
        this.loginRepository = loginRepository;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public ResponseEntity<?> login(LoginDto loginDto) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserLogin userLogin = UserLogin.builder()
                .email(loginDto.getEmail())
                .password(loginDto.getPassword())
                .build();

        //Save in UserLogin repository
        loginRepository.save(userLogin);

        return new ResponseEntity<>("User logged in successfully", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> userLoggedIn(String email) {

        Optional<UserLogin> loginOptional = loginRepository.findByEmail(email);
        loginOptional.orElseThrow(()-> new ApiException("User is not logged in."));

        return new ResponseEntity<>(loginOptional.get(), HttpStatus.FOUND);
    }
}
