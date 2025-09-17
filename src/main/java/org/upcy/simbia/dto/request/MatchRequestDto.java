package org.upcy.simbia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;

@Data
public class MatchRequestDto {
    @Schema(example = "1", description = "Employee ID")
    @NotNull(message = "Employee ID must not be null", groups = OnCreate.class)
    private Long idEmployee;

    @Schema(example = "1", description = "Post ID")
    @NotNull(message = "Post ID must not be null", groups = OnCreate.class)
    private Long idPost;

    @Schema(example = "10", description = "Origin Industry ID")
    @NotNull(message = "Origin Industry ID must not be null", groups = OnCreate.class)
    private Long industryOrigin;

    @Schema(example = "20", description = "Destination Industry ID")
    @NotNull(message = "Destination Industry ID must not be null", groups = OnCreate.class)
    private Long industryDestine;
}
