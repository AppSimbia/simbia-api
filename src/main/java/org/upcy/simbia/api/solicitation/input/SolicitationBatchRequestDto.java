package org.upcy.simbia.api.solicitation.input;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "SolicitationBatchRequest", description = "Lote de solicitações")
public record SolicitationBatchRequestDto(
        @Schema(description = "CNPJ da indústria", example = "12345678901234")
        String cnpjIndustry,

        @ArraySchema(
                schema = @Schema(implementation = SolicitationRequestDto.class),
                arraySchema = @Schema(description = "Lista de solicitações")
        )
        List<SolicitationRequestDto> solicitations
) {}