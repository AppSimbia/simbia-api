package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.IndustryTypeRequestDto;
import org.upcy.simbia.dto.response.IndustryTypeResponseDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/industry-types")
public interface IndustryTypeContract {

    @Operation(summary = "Create a new industry type")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Industry type successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<IndustryTypeResponseDto> createIndustryType(@Valid @RequestBody IndustryTypeRequestDto dto);

    @Operation(summary = "Get a specific industry type by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Industry type found"),
            @ApiResponse(responseCode = "404", description = "Industry type not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<IndustryTypeResponseDto> findById(@PathVariable Long id);

    @Operation(summary = "List all industry types")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of industry types successfully returned")
    })
    @GetMapping
    ResponseEntity<List<IndustryTypeResponseDto>> findAll();

    @Operation(summary = "Update an existing industry type")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Industry type successfully updated"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided"),
            @ApiResponse(responseCode = "404", description = "Industry type not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<IndustryTypeResponseDto> updateIndustryType(@PathVariable Long id, @Valid @RequestBody IndustryTypeRequestDto dto);

    @Operation(summary = "Delete an industry type by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Industry type successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Industry type not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteIndustryType(@PathVariable Long id);
}
