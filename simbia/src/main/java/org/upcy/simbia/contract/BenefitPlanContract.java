package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.BenefitPlanRequestDto;
import org.upcy.simbia.dto.response.BenefitPlanResponseDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/benefit-plans")
public interface BenefitPlanContract {

    @Operation(summary = "Create a new benefit plan")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Benefit plan successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<BenefitPlanResponseDto> create(@Valid @RequestBody BenefitPlanRequestDto dto);

    @Operation(summary = "List all benefit plans")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of benefit plans successfully returned")
    })
    @GetMapping
    ResponseEntity<List<BenefitPlanResponseDto>> findAll();

    @Operation(summary = "Get a specific benefit plan by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Benefit plan found"),
            @ApiResponse(responseCode = "404", description = "Benefit plan not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<BenefitPlanResponseDto> findById(@PathVariable Long id);

    @Operation(summary = "Update a benefit plan by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Benefit plan successfully updated"),
            @ApiResponse(responseCode = "404", description = "Benefit plan not found"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PutMapping("/{id}")
    ResponseEntity<BenefitPlanResponseDto> update(@PathVariable Long id,
                                                  @Valid @RequestBody BenefitPlanRequestDto dto);

    @Operation(summary = "Delete a benefit plan by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Benefit plan successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Benefit plan not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
