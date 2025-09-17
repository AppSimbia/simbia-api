package org.upcy.simbia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.PlanContract;
import org.upcy.simbia.dto.request.PlanRequestDto;
import org.upcy.simbia.dto.response.PlanResponseDto;
import org.upcy.simbia.service.PlanService;

import java.util.List;

@RestController
public class PlanController implements PlanContract {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @Override
    public ResponseEntity<PlanResponseDto> create(PlanRequestDto dto) {
        PlanResponseDto created = planService.createPlan(dto);
        return ResponseEntity.status(201).body(created);
    }

    @Override
    public ResponseEntity<List<PlanResponseDto>> getPlan() {
        return ResponseEntity.ok(planService.listPlans());
    }

    @Override
    public ResponseEntity<PlanResponseDto> findById(Long id) {
        return ResponseEntity.ok(planService.getPlan(id));
    }

    @Override
    public ResponseEntity<PlanResponseDto> update(Long id, PlanRequestDto dto) {
        return ResponseEntity.ok(planService.updatePlan(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        planService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
}
