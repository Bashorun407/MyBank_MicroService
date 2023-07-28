package com.akinnova.bankidentityserviceregistry.service;

import com.akinnova.bankidentityserviceregistry.dto.UserDto;
import com.akinnova.bankidentityserviceregistry.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    ResponseEntity<?> createUser(UserDto userDto);
    ResponseEntity<?> fetchAllUsers();
    ResponseEntity<?> findUserById(Long id);
    ResponseEntity<?> findUserByAccountNumber(String accountNumber);
    ResponseEntity<?> findUserByEmail(String email);

    ResponseEntity<?>updateUserDetail(UserDto userDto);
    ResponseEntity<?> deleteUserDetail(UserDto userDto);
}
