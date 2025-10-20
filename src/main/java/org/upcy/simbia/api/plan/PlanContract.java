package org.upcy.simbia.api.plan;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.upcy.simbia.api.plan.output.PlanResponseDto;

import java.util.List;

@RequestMapping("/plans")
public interface PlanContract {

    @Operation(summary = "Get a specific plan by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Plan found"),
            @ApiResponse(responseCode = "404", description = "Plan not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<PlanResponseDto> findPlanById(@PathVariable Long id);

    @Operation(summary = "Get all plans")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of plans retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "No plans found")
    })
    @GetMapping("/list")
    ResponseEntity<List<PlanResponseDto>> findAllPlan();

}