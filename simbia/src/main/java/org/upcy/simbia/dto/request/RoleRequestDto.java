package org.upcy.simbia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;

@Data
public class RoleRequestDto {
    @Schema(example = "Role example", description = "Role Name")
    @NotNull(message = "The role name must not be null", groups = OnCreate.class)
    @Pattern(regexp = ".*\\S.*\\S.*", message = "The name must be at least 2 characters long")
    private String roleName;
}
