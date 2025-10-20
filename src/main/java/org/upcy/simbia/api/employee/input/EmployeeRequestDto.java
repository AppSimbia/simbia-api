package org.upcy.simbia.api.employee.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.upcy.simbia.validation.OnCreate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequestDto {

    @Schema(example = "Employee example", description = "Employee name")
    @NotNull(message = "Employee name must not be null", groups = OnCreate.class)
    @Pattern(regexp = ".*\\S.*\\S.*", message = "The employee name must be at least 2 characters long")
    private String employeeName;

    @Schema(example = "1", description = "ID of the associated industry")
    @NotNull(groups = OnCreate.class)
    private Long idIndustry;

}
