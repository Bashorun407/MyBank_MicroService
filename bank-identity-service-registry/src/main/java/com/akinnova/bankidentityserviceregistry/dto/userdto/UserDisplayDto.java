package com.akinnova.bankidentityserviceregistry.dto.userdto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDisplayDto {
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String dateOfBirth;
    private String home_address;
    private String stateOfOrigin;
    private String phoneNumber;
    private String alternativeNumber;
    private String email;
    private String userStatus;
}
