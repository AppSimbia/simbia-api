package org.upcy.simbia.mapper;

import org.upcy.simbia.api.solicitation.input.SolicitationRequestDto;
import org.upcy.simbia.api.solicitation.output.SolicitationData;
import org.upcy.simbia.api.solicitation.output.SolicitationResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.Industry;
import org.upcy.simbia.dataprovider.persistence.entity.Post;

public class SolicitationMapper extends AbstractMapper<SolicitationData, SolicitationRequestDto, SolicitationResponseDto>{

    @Override
    public SolicitationData toEntity(SolicitationRequestDto requestDto) {
        return null;
    }

    @Override
    public SolicitationResponseDto toResponse(SolicitationData entity) {
        Post post = entity.post();
        Industry industry = entity.industry();

        return SolicitationResponseDto.builder()
                .idIndustry(industry != null ? industry.getId() : null)
                .cIndustryName(industry != null ? industry.getIndustryName() : null)
                .cIndustryImage(industry != null ? industry.getImage() : null)
                .idPost(post.getId())
                .cTitle(post.getTitle())
                .cCategoryName(post.getIdProductCategory().getCategoryName())
                .cDescription(post.getDescription())
                .cImage(post.getImage())
                .cMeasureUnit(post.getMeasureUnit())
                .cClassification(post.getClassification())
                .nQuantity(post.getQuantity())
                .cActive(post.getActive())
                .build();
    }
}
