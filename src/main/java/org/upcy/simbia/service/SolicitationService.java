package org.upcy.simbia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.api.solicitation.input.SolicitationRequestDto;
import org.upcy.simbia.api.solicitation.output.SolicitationData;
import org.upcy.simbia.api.solicitation.output.SolicitationResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.Industry;
import org.upcy.simbia.dataprovider.persistence.entity.Post;
import org.upcy.simbia.mapper.SolicitationMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitationService {

    private static final SolicitationMapper solicitationMapper = new SolicitationMapper();
    private final IndustryService industryService;
    private final PostService postService;

    public List<SolicitationResponseDto> getSolicitations(List<SolicitationRequestDto> request) {
        List<SolicitationResponseDto> solicitations = new ArrayList<>();

        request.forEach(solicitationRequest -> {
            Industry industry = solicitationRequest.getIdIndustry() == null ?
                    null : industryService.findEntityById(solicitationRequest.getIdIndustry());
            Post post = postService.findEntityById(solicitationRequest.getIdPost());

            SolicitationData solicitationData = getSolicitationData(post, industry);
            SolicitationResponseDto solicitationResponse = toResponse(solicitationData);
            solicitations.add(solicitationResponse);
        });

        return solicitations;
    }

    private SolicitationData getSolicitationData(Post post, Industry industry) {
        return new SolicitationData(post, industry);
    }

    private SolicitationResponseDto toResponse(SolicitationData solicitationData) {
        return solicitationMapper.toResponse(solicitationData);
    }
}