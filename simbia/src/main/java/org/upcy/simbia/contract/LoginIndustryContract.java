package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.LoginIndustryRequestDto;
import org.upcy.simbia.dto.response.LoginIndustryResponseDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/logins")
public interface LoginIndustryContract {

    @Operation(summary = "Create a new login")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "LoginIndustry created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<LoginIndustryResponseDto> createLogin(@Valid @RequestBody LoginIndustryRequestDto dto);

    @Operation(summary = "List all logins")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List returned successfully")
    })
    @GetMapping
    ResponseEntity<List<LoginIndustryResponseDto>> listLogins();

    @Operation(summary = "Get a login by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "LoginIndustry found"),
            @ApiResponse(responseCode = "404", description = "LoginIndustry not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<LoginIndustryResponseDto> findLoginById(@PathVariable Long id);

    @Operation(summary = "Update an existing login by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "LoginIndustry updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided"),
            @ApiResponse(responseCode = "404", description = "LoginIndustry not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<LoginIndustryResponseDto> updateLogin(@PathVariable Long id, @Valid @RequestBody LoginIndustryRequestDto dto);

    @Operation(summary = "Delete a login by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "LoginIndustry deleted successfully"),
            @ApiResponse(responseCode = "404", description = "LoginIndustry not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteLogin(@PathVariable Long id);

    @Operation(summary = "Update last login timestamp")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Last login updated successfully"),
            @ApiResponse(responseCode = "404", description = "LoginIndustry not found")
    })
    @PatchMapping("/{id}/last-login")
    ResponseEntity<Void> updateLastLogin(@PathVariable Long id);
}
