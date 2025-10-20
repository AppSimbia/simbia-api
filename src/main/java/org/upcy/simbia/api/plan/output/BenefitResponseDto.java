package org.upcy.simbia.api.plan.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BenefitResponseDto {
    private String benefitName;
    private String description;
}

