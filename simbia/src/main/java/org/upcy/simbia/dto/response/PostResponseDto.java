package org.upcy.simbia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;

import java.util.Date;

@Data
public class PostResponseDto {
    @Schema(example = "3", description = "ID of the associated login")
    private Long idLogin;

    @Schema(example = "5", description = "Product category ID")
    private Long idProductCategory;

    @Schema(example = "10", description = "Industry ID")
    private Long idIndustry;

    @Schema(example = "1", description = "Employee ID")
    private Long idEmployee;

    @Schema(example = "Fresh apples", description = "Title of the post")
    private String title;

    @Schema(example = "Organic apples harvested this season", description = "Detailed description of the post")
    private String description;

    @Schema(example = "100", description = "Quantity available")
    private Integer quantity;

    @Schema(example = "kg", description = "Measurement unit for the quantity")
    private String measureUnit;

    @Schema(example = "base64-image-data", description = "Base64 encoded image")
    private String image;

    @Schema(example = "2025-09-16", description = "Date when the post was published")
    private Date publicationDate;

    @Schema(example = "Andamento", description = "Vou pensar ainda")
    private String status;
}
