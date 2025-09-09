package org.upcy.simbia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.BenefitPlanDto;
import org.upcy.simbia.model.Benefit;
import org.upcy.simbia.model.BenefitPlan;
import org.upcy.simbia.model.Plan;
import org.upcy.simbia.repository.BenefitPlanRepository;
import org.upcy.simbia.repository.BenefitRepository;
import org.upcy.simbia.repository.PlanRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenefitPlanService {

    private final BenefitPlanRepository benefitPlanRepository;
    private final BenefitRepository benefitRepository;
    private final PlanRepository planRepository;

    public BenefitPlan create(BenefitPlanDto dto) {
        Benefit benefit = benefitRepository.findById(dto.getBenefit())
                .orElseThrow(() -> new RuntimeException("Benefit não encontrado"));

        Plan plan = planRepository.findById(dto.getPlan())
                .orElseThrow(() -> new RuntimeException("Plan não encontrado"));

        BenefitPlan benefitPlan = new BenefitPlan();
        benefitPlan.setBenefit(benefit);
        benefitPlan.setPlan(plan);
        benefitPlan.setActive("1");

        return benefitPlanRepository.save(benefitPlan);
    }

    public List<BenefitPlan> findAll() {
        return benefitPlanRepository.findAll();
    }

    public BenefitPlan findById(Long id) {
        return benefitPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BenefitPlan não encontrado"));
    }

    public BenefitPlan update(Long id, BenefitPlanDto dto) {
        BenefitPlan existing = findById(id);

        Benefit benefit = benefitRepository.findById(dto.getBenefit())
                .orElseThrow(() -> new RuntimeException("Benefit não encontrado"));

        Plan plan = planRepository.findById(dto.getPlan())
                .orElseThrow(() -> new RuntimeException("Plan não encontrado"));

        existing.setBenefit(benefit);
        existing.setPlan(plan);

        return benefitPlanRepository.save(existing);
    }

    public void delete(Long id) {
        BenefitPlan bp = findById(id);
        bp.setActive("0");
        benefitPlanRepository.save(bp);
    }
}
