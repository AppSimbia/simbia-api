package org.upcy.simbia.api.plan.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanResponseDto {
    private Long idPlan;
    private String planName;
    private Double price;
    private List<BenefitResponseDto> benefits;
}
