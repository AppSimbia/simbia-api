package org.upcy.simbia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;

@Data
public class BenefitPlanRequestDto {
    @Schema(example = "1", description = "Benefit Id")
    @NotNull(message = "Benefit ID must not be null", groups = OnCreate.class)
    private Long idBenefit;

    @Schema(example = "10", description = "Plan Id")
    @NotNull(message = "Plan ID must not be null", groups = OnCreate.class)
    private Long idPlan;
}
