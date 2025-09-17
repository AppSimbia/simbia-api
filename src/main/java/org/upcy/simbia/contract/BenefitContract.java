package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.BenefitRequestDto;
import org.upcy.simbia.dto.response.BenefitResponseDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/benefits")
public interface BenefitContract {

    @Operation(summary = "Create a new benefit")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Benefit successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<BenefitResponseDto> create(@Valid @RequestBody BenefitRequestDto dto);

    @Operation(summary = "Get a specific benefit by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Benefit found"),
            @ApiResponse(responseCode = "404", description = "Benefit not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<BenefitResponseDto> findById(@PathVariable Long id);

    @Operation(summary = "List all benefits")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of benefits successfully returned")
    })
    @GetMapping
    ResponseEntity<List<BenefitResponseDto>> findAll();

    @Operation(summary = "Update an existing benefit")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Benefit successfully updated"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided"),
            @ApiResponse(responseCode = "404", description = "Benefit not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<BenefitResponseDto> update(@PathVariable Long id, @Valid @RequestBody BenefitRequestDto dto);

    @Operation(summary = "Delete a benefit by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Benefit successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Benefit not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
