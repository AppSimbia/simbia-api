package org.upcy.simbia.api.post.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;

@Data
public class PostRequestDto {

    @Schema(example = "5", description = "Product category ID")
    @NotNull(message = "Product category ID must not be null", groups = OnCreate.class)
    private Long idProductCategory;

    @Schema(example = "10", description = "Industry ID")
    @NotNull(message = "Industry ID must not be null", groups = OnCreate.class)
    private Long idIndustry;

    @Schema(example = "1", description = "Employee ID")
    @NotNull(message = "Employee ID must not be null", groups = OnCreate.class)
    private Long idEmployee;

    @Schema(example = "Fresh apples", description = "Title of the post")
    @NotNull(message = "Title must not be null", groups = OnCreate.class)
    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 characters")
    private String title;

    @Schema(example = "Organic apples harvested this season", description = "Detailed description of the post")
    @NotNull(message = "Description must not be null", groups = OnCreate.class)
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;

    @Schema(example = "100", description = "Quantity available")
    @NotNull(message = "Quantity must not be null", groups = OnCreate.class)
    private Integer quantity;

    @Schema(example = "kg", description = "Measurement unit for the quantity")
    @NotNull(message = "Measure unit must not be null", groups = OnCreate.class)
    private String measureUnit;

    @Schema(example = "1", description = "Classification available")
    @NotNull(message = "Classification must not be null", groups = OnCreate.class)
    private String classification;

    @Schema(example = "base64-image-data", description = "Base64 encoded image")
    private String image;

}
