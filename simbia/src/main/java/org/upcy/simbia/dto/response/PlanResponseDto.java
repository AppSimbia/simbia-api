package org.upcy.simbia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;

import java.math.BigDecimal;

@Data
public class PlanResponseDto {
    @Schema(example = "Premium Plan", description = "Plan name")
    private String planName;

    @Schema(example = "99.90", description = "Plan price")
    private BigDecimal price;
}
