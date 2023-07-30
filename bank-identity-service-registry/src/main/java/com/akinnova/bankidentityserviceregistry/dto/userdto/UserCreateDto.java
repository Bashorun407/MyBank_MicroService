package com.akinnova.bankidentityserviceregistry.dto.userdto;

import lombok.Data;

@Data
public class UserCreateDto {
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String dateOfBirth;
    private String home_address;
    private String stateOfOrigin;
    private String uniqueId;
    private String phoneNumber;
    private String alternativeNumber;
    private String email;
    private String password;
    private String accountType;
    private String role;
    private String createdBy;
}
