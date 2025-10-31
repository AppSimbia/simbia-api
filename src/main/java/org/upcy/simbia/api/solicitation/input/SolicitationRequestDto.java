package org.upcy.simbia.api.solicitation.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitationRequestDto {

    @Schema(description = "ID do post", example = "10")
    @NotNull(message = "O ID do post não pode ser null")
    private Long idPost;

    @Schema(description = "CNPJ da indústria compradora", example = "valor")
    @CNPJ
    private String cnpjIndustry;

    @Schema(description = "Tipo da Solicitação", example = "valor")
    @NotNull(message = "O solicitation type não pode ser null")
    private String solicitationType;

}
