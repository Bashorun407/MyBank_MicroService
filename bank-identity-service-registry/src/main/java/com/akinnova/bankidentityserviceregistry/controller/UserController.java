package com.akinnova.bankidentityserviceregistry.controller;

import com.akinnova.bankidentityserviceregistry.dto.userdto.UserCreateDto;
import com.akinnova.bankidentityserviceregistry.dto.userdto.UserDeleteDto;
import com.akinnova.bankidentityserviceregistry.dto.userdto.UserUpdateDto;
import com.akinnova.bankidentityserviceregistry.entity.UserEntity;
import com.akinnova.bankidentityserviceregistry.response.ResponsePojo;
import com.akinnova.bankidentityserviceregistry.service.userservice.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user/auth")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/newUser")
    public ResponsePojo<UserEntity> createUser(@RequestBody UserCreateDto userDto) {
       return userService.createUser(userDto);
    }

    @GetMapping("/users")
    public ResponseEntity<?> fetchAllUsers() {
        return userService.fetchAllUsers();
    }

    @GetMapping("/userId/{id}")
    public ResponseEntity<?> findUserByUniqueId(@PathVariable String id) {
        return userService.findUserByUniqueId(id);
    }

    @GetMapping("/userEmail/{email}")
    public ResponseEntity<?> findUserByEmail(@PathVariable String email) {
        return userService.findUserByEmail(email);
    }

    @PutMapping("/update")
    public ResponsePojo<UserEntity> updateUserDetail(@RequestBody UserUpdateDto userDto) {
        return userService.updateUserDetail(userDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteUserDetail(@RequestBody UserDeleteDto userDeleteDto) {
        return userService.deleteUserDetail(userDeleteDto);
    }
}
