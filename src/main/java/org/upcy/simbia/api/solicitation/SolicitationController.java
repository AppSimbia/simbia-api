package org.upcy.simbia.api.solicitation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.api.solicitation.input.SolicitationBatchRequestDto;
import org.upcy.simbia.api.solicitation.input.SolicitationRequestDto;
import org.upcy.simbia.api.solicitation.output.SolicitationResponseDto;
import org.upcy.simbia.service.SolicitationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SolicitationController implements SolicitationContract{

    private final SolicitationService solicitationService;

    @Override
    public List<SolicitationResponseDto> getInfoSolicitations(SolicitationBatchRequestDto request) {
        return solicitationService.getSolicitations(request);
    }
}
