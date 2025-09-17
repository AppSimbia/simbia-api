package org.upcy.simbia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;

@Data
public class EmployeeRequestDto {
    @Schema(example = "3", description = "ID of the associated login")
    @NotNull(groups = OnCreate.class)
    private Long idLogin;

    @Schema(example = "Employee example", description = "Employee name")
    @NotNull(message = "Employee name must not be null", groups = OnCreate.class)
    @Pattern(regexp = ".*\\S.*\\S.*", message = "The employee name must be at least 2 characters long")
    private String employeeName;
}
