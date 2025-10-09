package org.upcy.simbia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginIndustryResponseDto {
    @Schema(example = "john.doe", description = "Username of the user")
    private String userName;

    @Schema(example = "a1b2c3d4-5678-90ab-cdef-1234567890ab", description = "Password UUID")
    private String pwdUUID ;
}
