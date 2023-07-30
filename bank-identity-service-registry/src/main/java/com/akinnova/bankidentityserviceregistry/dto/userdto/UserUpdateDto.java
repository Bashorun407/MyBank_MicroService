package com.akinnova.bankidentityserviceregistry.dto.userdto;

import lombok.Data;

@Data
public class UserUpdateDto {
    private String firstName;
    private String lastName;
    private String otherName;
    private String home_address;
    private String phoneNumber;
    private String alternativeNumber;
    private String email;
    private String password;
    private String modifiedBy;
    private String userStatus;
}
