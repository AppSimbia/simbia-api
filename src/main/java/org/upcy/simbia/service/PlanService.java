package org.upcy.simbia.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.upcy.simbia.api.plan.output.BenefitResponseDto;
import org.upcy.simbia.api.plan.output.PlanResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.Benefit;
import org.upcy.simbia.dataprovider.persistence.entity.Plan;
import org.upcy.simbia.dataprovider.persistence.repository.BenefitRepository;
import org.upcy.simbia.dataprovider.persistence.repository.PlanRepository;
import org.upcy.simbia.mapper.BenefitMapper;
import org.upcy.simbia.mapper.PlanMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanService {

    private static final PlanMapper planMapper = new PlanMapper();
    private static final BenefitMapper benefitMapper = new BenefitMapper();
    private final PlanRepository planRepository;
    private final BenefitRepository benefitRepository;

    @Cacheable("plans")
    public List<PlanResponseDto> findAllPlan() {
        return planRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Cacheable("planId")
    public PlanResponseDto findPlanById(Long id) {
        return toResponse(findEntityById(id));
    }

    public Plan findEntityById(Long id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan not found"));
    }

    private PlanResponseDto toResponse(Plan plan) {
        PlanResponseDto planResponseDto = planMapper.toResponse(plan);
        planResponseDto.setBenefits(benefitRepository.findAllBenefitsByIdPlan(plan.getId()).stream()
                .map(this::toBenefitResponse)
                .collect(Collectors.toList()));
        return planResponseDto;
    }

    private BenefitResponseDto toBenefitResponse(Benefit benefit) {
        return benefitMapper.toResponse(benefit);
    }

}
