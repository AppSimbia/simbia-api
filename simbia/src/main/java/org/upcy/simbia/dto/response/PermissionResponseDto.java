package org.upcy.simbia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PermissionResponseDto {
    @Schema(example = "Permission example", description = "Permission Name")
    private String permissionName;
}
