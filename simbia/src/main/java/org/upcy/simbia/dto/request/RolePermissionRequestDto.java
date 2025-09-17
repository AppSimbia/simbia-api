package org.upcy.simbia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;

@Data
public class RolePermissionRequestDto {
    @Schema(example = "1", description = "Permission Id")
    @NotNull(message = "Permission ID must not be null", groups = OnCreate.class)
    private Long idPermission;

    @Schema(example = "10", description = "Role Id")
    @NotNull(message = "Role ID must not be null", groups = OnCreate.class)
    private Long idRole;
}
