package com.akinnova.bankidentityserviceregistry.service;

import com.akinnova.bankidentityserviceregistry.dto.UserDto;
import org.springframework.http.ResponseEntity;

public class UserService implements  IUserService{


    @Override
    public ResponseEntity<?> createUser(UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> fetchAllUsers() {
        return null;
    }

    @Override
    public ResponseEntity<?> findUserById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<?> findUserByAccountNumber(String accountNumber) {
        return null;
    }

    @Override
    public ResponseEntity<?> findUserByEmail(String email) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateUserDetail(UserDto userDto) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteUserDetail(UserDto userDto) {
        return null;
    }
}
