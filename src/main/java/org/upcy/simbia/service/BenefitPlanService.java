package org.upcy.simbia.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.BenefitPlanRequestDto;
import org.upcy.simbia.dto.response.BenefitPlanResponseDto;
import org.upcy.simbia.model.Benefit;
import org.upcy.simbia.model.BenefitPlan;
import org.upcy.simbia.model.Plan;
import org.upcy.simbia.repository.BenefitPlanRepository;
import org.upcy.simbia.repository.BenefitRepository;
import org.upcy.simbia.repository.PlanRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BenefitPlanService {

    private final BenefitPlanRepository benefitPlanRepository;
    private final BenefitRepository benefitRepository;
    private final PlanRepository planRepository;
    private final ObjectMapper objectMapper;

    private BenefitPlanResponseDto toDto(BenefitPlan entity) {
        return objectMapper.convertValue(entity, BenefitPlanResponseDto.class);
    }

    private Benefit getBenefit(Long id) {
        return benefitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Benefit not found"));
    }

    private Plan getPlan(Long id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan not found"));
    }

    public List<BenefitPlanResponseDto> listBenefitPlans() {
        return benefitPlanRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public BenefitPlanResponseDto findBenefitPlan(Long id) {
        BenefitPlan benefitPlan = benefitPlanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Benefit plan not found"));
        return toDto(benefitPlan);
    }

    public BenefitPlanResponseDto insertBenefitPlan(@Valid BenefitPlanRequestDto dto) {
        Benefit benefit = getBenefit(dto.getIdBenefit());
        Plan plan = getPlan(dto.getIdPlan());

        BenefitPlan entity = new BenefitPlan();
        entity.setIdBenefit(benefit);
        entity.setIdPlan(plan);
        entity.setActive("1");

        benefitPlanRepository.save(entity);
        return toDto(entity);
    }

    @Transactional
    public BenefitPlanResponseDto updateBenefitPlan(Long id, @Valid BenefitPlanRequestDto dto) {
        BenefitPlan existing = benefitPlanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Benefit plan not found"));

        Benefit benefit = getBenefit(dto.getIdBenefit());
        Plan plan = getPlan(dto.getIdPlan());

        existing.setIdBenefit(benefit);
        existing.setIdPlan(plan);

        benefitPlanRepository.save(existing);
        return toDto(existing);
    }

    public void deleteBenefitPlan(Long id) {
        BenefitPlan bp = benefitPlanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Benefit plan not found"));

        bp.setActive("0");
        benefitPlanRepository.save(bp);
    }
}
