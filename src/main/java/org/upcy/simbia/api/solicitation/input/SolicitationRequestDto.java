package org.upcy.simbia.api.solicitation.input;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitationRequestDto {

    @Schema(description = "ID do post", example = "10")
    private Long idPost;

    @Schema(description = "Algum outro campo", example = "valor")
    private Long idIndustry;

}
