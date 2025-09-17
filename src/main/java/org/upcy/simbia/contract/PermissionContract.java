package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.PermissionRequestDto;
import org.upcy.simbia.dto.response.PermissionResponseDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/permissions")
public interface PermissionContract {

    @Operation(summary = "Create a new permission")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Permission successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<PermissionResponseDto> createPermission(@Valid @RequestBody PermissionRequestDto dto);

    @Operation(summary = "List all permissions")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of permissions returned successfully")
    })
    @GetMapping
    ResponseEntity<List<PermissionResponseDto>> listPermissions();

    @Operation(summary = "Get a specific permission by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Permission found"),
            @ApiResponse(responseCode = "404", description = "Permission not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<PermissionResponseDto> findPermissionById(@PathVariable Long id);

    @Operation(summary = "Update an existing permission by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Permission updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided"),
            @ApiResponse(responseCode = "404", description = "Permission not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<PermissionResponseDto> updatePermission(@PathVariable Long id, @Valid @RequestBody PermissionRequestDto dto);

    @Operation(summary = "Delete a permission by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Permission deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Permission not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deletePermission(@PathVariable Long id);
}
