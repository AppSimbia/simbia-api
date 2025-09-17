package org.upcy.simbia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;

@Data
public class PermissionRequestDto {
    @Schema(example = "Permission example", description = "Permission Name")
    @NotNull(message = "The permission name must not be null", groups = OnCreate.class)
    @Pattern(regexp = ".*\\S.*\\S.*", message = "The name must be at least 2 characters long")
    private String permissionName;
}
