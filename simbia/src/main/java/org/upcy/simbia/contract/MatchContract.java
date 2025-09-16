package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.MatchRequestDto;
import org.upcy.simbia.dto.response.MatchResponseDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/matches")
public interface MatchContract {

    @Operation(summary = "Create a new match")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Match successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<MatchResponseDto> create(@Valid @RequestBody MatchRequestDto dto);

    @Operation(summary = "List all matches")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of matches successfully returned")
    })
    @GetMapping
    ResponseEntity<List<MatchResponseDto>> findAll();

    @Operation(summary = "Find a match by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Match found"),
            @ApiResponse(responseCode = "404", description = "Match not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<MatchResponseDto> findById(@PathVariable Long id);

    @Operation(summary = "Update an existing match")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Match successfully updated"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided"),
            @ApiResponse(responseCode = "404", description = "Match not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<MatchResponseDto> update(@PathVariable Long id, @Valid @RequestBody MatchRequestDto dto);

    @Operation(summary = "Delete a match by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Match successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Match not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Update the status of a match")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Match status successfully updated"),
            @ApiResponse(responseCode = "404", description = "Match not found")
    })
    @PatchMapping("/{id}/status")
    ResponseEntity<MatchResponseDto> updateStatus(@PathVariable Long id, @RequestParam String status);
}
