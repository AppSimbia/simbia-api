package org.upcy.simbia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;

@Data
public class RoleEmployeeResponseDto {
    @Schema(example = "1", description = "Role Id")
    private Long idRole;

    @Schema(example = "10", description = "Employee Id")
    private Long idEmployee;
}
