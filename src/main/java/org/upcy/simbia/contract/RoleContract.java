package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.RoleRequestDto;
import org.upcy.simbia.dto.response.RoleResponseDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/roles")
public interface RoleContract {

    @Operation(summary = "Create a new role")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Role successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<RoleResponseDto> createRole(@Valid @RequestBody RoleRequestDto dto);

    @Operation(summary = "List all roles")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of roles returned successfully")
    })
    @GetMapping
    ResponseEntity<List<RoleResponseDto>> listRoles();

    @Operation(summary = "Get a specific role by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Role found"),
            @ApiResponse(responseCode = "404", description = "Role not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<RoleResponseDto> findRoleById(@PathVariable Long id);

    @Operation(summary = "Update an existing role by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Role updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided"),
            @ApiResponse(responseCode = "404", description = "Role not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<RoleResponseDto> updateRole(@PathVariable Long id, @Valid @RequestBody RoleRequestDto dto);

    @Operation(summary = "Delete a role by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Role deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Role not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRole(@PathVariable Long id);
}
