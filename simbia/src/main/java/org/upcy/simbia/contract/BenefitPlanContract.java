package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.BenefitPlanDto;
import org.upcy.simbia.model.BenefitPlan;

import java.util.List;

@RequestMapping("/benefit-plans")
public interface BenefitPlanContract {

    @PostMapping
    ResponseEntity<BenefitPlan> create(@RequestBody BenefitPlanDto dto);

    @GetMapping
    ResponseEntity<List<BenefitPlan>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<BenefitPlan> findById(@PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
