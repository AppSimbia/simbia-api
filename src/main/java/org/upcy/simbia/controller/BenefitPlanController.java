package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.BenefitPlanContract;
import org.upcy.simbia.dto.request.BenefitPlanRequestDto;
import org.upcy.simbia.dto.response.BenefitPlanResponseDto;
import org.upcy.simbia.service.BenefitPlanService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BenefitPlanController implements BenefitPlanContract {

    private final BenefitPlanService benefitPlanService;

    @Override
    public ResponseEntity<BenefitPlanResponseDto> create(BenefitPlanRequestDto dto) {
        return ResponseEntity.status(201).body(benefitPlanService.insertBenefitPlan(dto));
    }

    @Override
    public ResponseEntity<List<BenefitPlanResponseDto>> findAll() {
        return ResponseEntity.ok(benefitPlanService.listBenefitPlans());
    }

    @Override
    public ResponseEntity<BenefitPlanResponseDto> findById(Long id) {
        return ResponseEntity.ok(benefitPlanService.findBenefitPlan(id));
    }

    @Override
    public ResponseEntity<BenefitPlanResponseDto> update(Long id, BenefitPlanRequestDto dto) {
        return ResponseEntity.ok(benefitPlanService.updateBenefitPlan(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        benefitPlanService.deleteBenefitPlan(id);
        return ResponseEntity.noContent().build();
    }
}
