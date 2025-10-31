package org.upcy.simbia.mapper;

import org.upcy.simbia.api.industry.output.IndustryResponseDto;
import org.upcy.simbia.api.solicitation.input.SolicitationRequestDto;
import org.upcy.simbia.api.solicitation.output.SolicitationData;
import org.upcy.simbia.api.solicitation.output.SolicitationResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.Post;

public class SolicitationMapper extends AbstractMapper<SolicitationData, SolicitationRequestDto, SolicitationResponseDto>{

    @Override
    public SolicitationData toEntity(SolicitationRequestDto requestDto) {
        return null;
    }

    @Override
    public SolicitationResponseDto toResponse(SolicitationData entity) {
        Post post = entity.post();
        IndustryResponseDto industry = entity.industry();

        return SolicitationResponseDto.builder()
                .cnpjIndustry(industry != null ? industry.getCnpj() : null)
                .industryImage(industry != null ? industry.getIndustryName() : null)
                .industryImage(industry != null ? industry.getImage() : null)
                .idPost(post.getId())
                .title(post.getTitle())
                .categoryName(post.getIdProductCategory().getCategoryName())
                .image(post.getImage())
                .measureUnit(post.getMeasureUnit())
                .classification(post.getClassification())
                .quantity(post.getQuantity())
                .solicitationType(entity.solicitationType())
                .solicitationText(entity.solicitationText())
                .build();
    }
}
