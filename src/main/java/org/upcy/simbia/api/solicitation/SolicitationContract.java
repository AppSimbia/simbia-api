package org.upcy.simbia.api.solicitation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.upcy.simbia.api.solicitation.input.SolicitationBatchRequestDto;
import org.upcy.simbia.api.solicitation.input.SolicitationRequestDto;
import org.upcy.simbia.api.solicitation.output.SolicitationResponseDto;

import java.util.List;

@RequestMapping("/solicitations")
public interface SolicitationContract {

    @Operation(summary = "Get a solicitation by IDs")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Solicitation info found"),
            @ApiResponse(responseCode = "404", description = "Solicitation info not found")
    })
    @PostMapping
    List<SolicitationResponseDto> getInfoSolicitations(@RequestBody SolicitationBatchRequestDto request);

}
