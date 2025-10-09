package org.upcy.simbia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BenefitResponseDto {
    @Schema(example = "Benefit example", description = "Benefit Name")
    private String benefitName;

    @Schema(example = "Description exaple", description = "Benefit description")
    private String description;
}

