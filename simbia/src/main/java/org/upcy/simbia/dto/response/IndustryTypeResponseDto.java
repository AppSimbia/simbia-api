package org.upcy.simbia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class IndustryTypeResponseDto {
    @Schema(example = "Industry example", description = "Industry Name")
    private String industryTypeName;

    @Schema(example = "Description exaple", description = "Industry description")
    private String info;
}
