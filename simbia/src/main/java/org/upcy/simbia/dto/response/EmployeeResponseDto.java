package org.upcy.simbia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class EmployeeResponseDto {
    @Schema(example = "Employee example", description = "Employee name")
    private String employeeName;

    @Schema(example = "3", description = "ID of the associated login")
    private Long idLogin;
}
