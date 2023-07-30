package com.akinnova.bankidentityserviceregistry.service.userservice;

import com.akinnova.bankidentityserviceregistry.dto.userdto.UserCreateDto;
import com.akinnova.bankidentityserviceregistry.dto.userdto.UserDeleteDto;
import com.akinnova.bankidentityserviceregistry.dto.userdto.UserDisplayDto;
import com.akinnova.bankidentityserviceregistry.dto.userdto.UserUpdateDto;
import com.akinnova.bankidentityserviceregistry.entity.UserEntity;
import com.akinnova.bankidentityserviceregistry.response.ResponsePojo;
import org.springframework.http.ResponseEntity;

public interface IUserService {
    ResponsePojo<UserEntity> createUser(UserCreateDto userDto);
    ResponseEntity<?> fetchAllUsers();
    ResponseEntity<?> findUserByUniqueId(String id);
    ResponseEntity<?> findUserByEmail(String email);

    ResponsePojo<UserEntity> updateUserDetail(UserUpdateDto userDto);
    ResponseEntity<?> deleteUserDetail(UserDeleteDto userDeleteDto);
}
