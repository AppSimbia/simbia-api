package org.upcy.simbia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;

@Data
public class LoginRequestDto {
    @Schema(example = "john.doe", description = "Username of the user")
    @NotNull(message = "Username must not be null", groups = OnCreate.class)
    @Pattern(regexp = ".*\\S.*\\S.*", message = "Username must be at least 2 non-blank characters")
    private String userName;

    @Schema(example = "a1b2c3d4-5678-90ab-cdef-1234567890ab", description = "Password UUID")
    @NotNull(message = "Password UUID must not be null", groups = OnCreate.class)
    @Pattern(regexp = ".*\\S.*\\S.*", message = "Password UUID must be at least 2 non-blank characters")
    private String pwdUUID;
}
