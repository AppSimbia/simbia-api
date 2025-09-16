package org.upcy.simbia.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;
import io.swagger.v3.oas.annotations.media.Schema;

@Data
public class BenefitRequestDto {
    @Schema(example = "Benefit example", description = "Benefit Name")
    @NotNull(message = "The benefit name must not be null", groups = OnCreate.class)
    @Pattern(regexp = ".*\\S.*\\S.*", message = "The name must be at least 2 characters long")
    private String benefitName;

    @Schema(example = "Description exaple", description = "Benefit description")
    @NotNull(groups = OnCreate.class)
    @Pattern(regexp = ".*\\S.*\\S.*", message = "The description must be at least 2 characters long")
    private String description;
}
