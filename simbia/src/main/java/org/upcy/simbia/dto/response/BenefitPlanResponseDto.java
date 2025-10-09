package org.upcy.simbia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BenefitPlanResponseDto {
    @Schema(example = "1", description = "Benefit Id")
    private Long idBenefit;

    @Schema(example = "10", description = "Plan Id")
    private Long idPlan;
}
