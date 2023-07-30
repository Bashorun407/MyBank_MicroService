package com.akinnova.bankidentityserviceregistry.dto.userdto;

import lombok.Data;

@Data
public class UserDeleteDto {
    private String uniqueId;
    private String deleteBy;
}
