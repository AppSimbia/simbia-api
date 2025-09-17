package org.upcy.simbia.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String userName;

    private String pwdUUID ;

    private String isFirstLogin;
}
