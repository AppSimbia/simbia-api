package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.IndustryRequestDto;
import org.upcy.simbia.dto.response.IndustryResponseDto;

import jakarta.validation.Valid;
import java.util.Optional;

@RequestMapping("/industries")
public interface IndustryContract {

    @Operation(summary = "Create a new industry")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Industry successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<IndustryResponseDto> createIndustry(@Valid @RequestBody IndustryRequestDto dto);

    @Operation(summary = "Get a specific industry by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Industry found"),
            @ApiResponse(responseCode = "404", description = "Industry not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<Optional<IndustryResponseDto>> findIndustryById(@PathVariable Long id);

    @Operation(summary = "Update an existing industry")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Industry successfully updated"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided"),
            @ApiResponse(responseCode = "404", description = "Industry not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<Optional<IndustryResponseDto>> updateIndustry(@PathVariable Long id,
                                                                 @Valid @RequestBody IndustryRequestDto dto);

    @Operation(summary = "Delete an industry by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Industry successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Industry not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteIndustry(@PathVariable Long id);
}
