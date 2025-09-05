package org.upcy.simbia.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.PlanContract;
import org.upcy.simbia.dto.PlanDto;
import org.upcy.simbia.model.Plan;
import org.upcy.simbia.service.PlanService;

import java.util.List;

@RestController
public class PlanController implements PlanContract {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @Override
    public ResponseEntity<Plan> create(PlanDto dto) {
        Plan created = planService.create(dto);
        return ResponseEntity.ok(created);
    }

    @Override
    public ResponseEntity<List<Plan>> findAll() {
        return ResponseEntity.ok(planService.findAll());
    }

    @Override
    public ResponseEntity<Plan> findById(Long id) {
        return planService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Plan> update(Long id, PlanDto dto) {
        try {
            Plan updated = planService.update(id, dto);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        try {
            planService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

