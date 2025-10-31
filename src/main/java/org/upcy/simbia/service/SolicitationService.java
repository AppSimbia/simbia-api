package org.upcy.simbia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.upcy.simbia.api.industry.output.IndustryResponseDto;
import org.upcy.simbia.api.solicitation.input.SolicitationBatchRequestDto;
import org.upcy.simbia.api.solicitation.output.SolicitationData;
import org.upcy.simbia.api.solicitation.output.SolicitationResponseDto;
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

    @Cacheable("solicitations")
    public List<SolicitationResponseDto> getSolicitations(SolicitationBatchRequestDto request) {
        List<SolicitationResponseDto> solicitations = new ArrayList<>();

        postService.findAllSolicitationsByIndustry(request.cnpjIndustry()).forEach(post -> {
            SolicitationData solicitationData = new SolicitationData(post, null, "POST");
            SolicitationResponseDto solicitationResponse = toResponse(solicitationData);
            solicitations.add(solicitationResponse);
        });

        request.solicitations().forEach(solicitationRequest -> {
            IndustryResponseDto industry = solicitationRequest.getCnpjIndustry() == null ?
                    null : industryService.findIndustryByCnpj(solicitationRequest.getCnpjIndustry());
            Post post = postService.findEntityById(solicitationRequest.getIdPost());

            SolicitationData solicitationData = new SolicitationData(post, industry, solicitationRequest.getSolicitationType());
            SolicitationResponseDto solicitationResponse = toResponse(solicitationData);
            solicitations.add(solicitationResponse);
        });

        return solicitations;
    }

    private SolicitationResponseDto toResponse(SolicitationData solicitationData) {
        return solicitationMapper.toResponse(solicitationData);
    }
}