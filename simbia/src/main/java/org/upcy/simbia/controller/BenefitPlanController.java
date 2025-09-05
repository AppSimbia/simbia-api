package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.BenefitPlanContract;
import org.upcy.simbia.dto.BenefitPlanDto;
import org.upcy.simbia.model.BenefitPlan;
import org.upcy.simbia.service.BenefitPlanService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BenefitPlanController implements BenefitPlanContract {

    private final BenefitPlanService benefitPlanService;

    @Override
    public ResponseEntity<BenefitPlan> create(BenefitPlanDto dto) {
        return ResponseEntity.ok(benefitPlanService.create(dto));
    }

    @Override
    public ResponseEntity<List<BenefitPlan>> findAll() {
        return ResponseEntity.ok(benefitPlanService.findAll());
    }

    @Override
    public ResponseEntity<BenefitPlan> findById(Long id) {
        return ResponseEntity.ok(benefitPlanService.findById(id));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        benefitPlanService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
