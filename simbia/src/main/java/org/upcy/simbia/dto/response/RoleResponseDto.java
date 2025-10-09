package org.upcy.simbia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class RoleResponseDto {
    @Schema(example = "Role example", description = "Role Name")
    private String roleName;
}
