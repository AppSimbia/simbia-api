package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.RolePermissionRequestDto;
import org.upcy.simbia.dto.response.RolePermissionResponseDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/role-permissions")
public interface RolePermissionContract {

    @Operation(summary = "Create a new role-permission association")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Association successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<RolePermissionResponseDto> createRolePermission(@Valid @RequestBody RolePermissionRequestDto dto);

    @Operation(summary = "List all role-permission associations")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List returned successfully")
    })
    @GetMapping
    ResponseEntity<List<RolePermissionResponseDto>> listRolePermissions();

    @Operation(summary = "Get a role-permission association by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Association found"),
            @ApiResponse(responseCode = "404", description = "Association not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<RolePermissionResponseDto> findRolePermissionById(@PathVariable Long id);

    @Operation(summary = "Delete a role-permission association by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Association deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Association not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRolePermission(@PathVariable Long id);
}
