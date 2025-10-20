package org.upcy.simbia.mapper;

import org.upcy.simbia.api.plan.output.PlanResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.Plan;

public class PlanMapper extends AbstractMapper<Plan, Object, PlanResponseDto> {

    @Override
    public Plan toEntity(Object requestDto) {
        return null;
    }

    @Override
    public PlanResponseDto toResponse(Plan entity) {
        return PlanResponseDto.builder()
                .idPlan(entity.getId())
                .planName(entity.getPlanName())
                .price(entity.getPrice())
                .build();
    }
}
