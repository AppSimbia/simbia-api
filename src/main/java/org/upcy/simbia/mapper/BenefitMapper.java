package org.upcy.simbia.mapper;

import org.upcy.simbia.dataprovider.persistence.entity.Benefit;
import org.upcy.simbia.api.plan.output.BenefitResponseDto;

public class BenefitMapper extends AbstractMapper<Benefit, Object, BenefitResponseDto> {
    @Override
    public Benefit toEntity(Object requestDto) {
        return null;
    }

    @Override
    public BenefitResponseDto toResponse(Benefit entity) {
        return BenefitResponseDto.builder()
                .benefitName(entity.getBenefitName())
                .description(entity.getDescription())
                .build();
    }
}
