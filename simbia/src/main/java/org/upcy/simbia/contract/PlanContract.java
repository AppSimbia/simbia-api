package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.PlanRequestDto;
import org.upcy.simbia.dto.response.PlanResponseDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/plans")
public interface PlanContract {

    @Operation(summary = "Create a new plan")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Plan created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<PlanResponseDto> create(@Valid @RequestBody PlanRequestDto dto);

    @Operation(summary = "List all plans")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of plans returned successfully")
    })
    @GetMapping
    ResponseEntity<List<PlanResponseDto>> getPlan();

    @Operation(summary = "Get a plan by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Plan found"),
            @ApiResponse(responseCode = "404", description = "Plan not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<PlanResponseDto> findById(@PathVariable Long id);

    @Operation(summary = "Update an existing plan by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Plan updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided"),
            @ApiResponse(responseCode = "404", description = "Plan not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<PlanResponseDto> update(@PathVariable Long id, @Valid @RequestBody PlanRequestDto dto);

    @Operation(summary = "Delete a plan by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Plan deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Plan not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
