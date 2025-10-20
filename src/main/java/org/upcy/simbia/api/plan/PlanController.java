package org.upcy.simbia.api.plan;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.api.plan.output.PlanResponseDto;
import org.upcy.simbia.service.PlanService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PlanController implements PlanContract {

    private final PlanService planService;

    @Override
    public ResponseEntity<PlanResponseDto> findPlanById(Long id) {
        return ResponseEntity.ok(planService.findPlanById(id));
    }

    @Override
    public ResponseEntity<List<PlanResponseDto>> findAllPlan() {
        return ResponseEntity.ok(planService.findAllPlan());
    }
}
