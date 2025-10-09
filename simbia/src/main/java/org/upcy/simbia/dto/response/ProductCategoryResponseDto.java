package org.upcy.simbia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductCategoryResponseDto {
    @Schema(example = "Category example", description = "Category Name")
    private String categoryName;

    @Schema(example = "Description exaple", description = "Industry description")
    private String info;
}
