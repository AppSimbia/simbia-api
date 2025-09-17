package org.upcy.simbia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;

import java.math.BigDecimal;

@Data
public class PlanRequestDto {
    @Schema(example = "Premium Plan", description = "Plan name")
    @NotNull(message = "Plan name must not be null", groups = OnCreate.class)
    @Pattern(regexp = ".*\\S.*\\S.*", message = "The plan name must be at least 2 characters long")
    private String planName;

    @Schema(example = "99.90", description = "Plan price")
    @NotNull(message = "Price must not be null", groups = OnCreate.class)
    private BigDecimal price;
}
