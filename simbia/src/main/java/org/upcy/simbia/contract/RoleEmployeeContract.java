package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.RoleEmployeeRequestDto;
import org.upcy.simbia.dto.response.RoleEmployeeResponseDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/role-employees")
public interface RoleEmployeeContract {

    @Operation(summary = "Create a new role-employee association")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Association successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<RoleEmployeeResponseDto> createRoleEmployee(@Valid @RequestBody RoleEmployeeRequestDto dto);

    @Operation(summary = "List all role-employee associations")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List returned successfully")
    })
    @GetMapping
    ResponseEntity<List<RoleEmployeeResponseDto>> listRoleEmployees();

    @Operation(summary = "Get a role-employee association by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Association found"),
            @ApiResponse(responseCode = "404", description = "Association not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<RoleEmployeeResponseDto> findRoleEmployeeById(@PathVariable Long id);

    @Operation(summary = "Update a role-employee association by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Association updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided"),
            @ApiResponse(responseCode = "404", description = "Association not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<RoleEmployeeResponseDto> updateRoleEmployee(@PathVariable Long id, @Valid @RequestBody RoleEmployeeRequestDto dto);

    @Operation(summary = "Delete a role-employee association by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Association deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Association not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRoleEmployee(@PathVariable Long id);
}
