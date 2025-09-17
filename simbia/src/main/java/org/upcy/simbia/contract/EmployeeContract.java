package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.EmployeeRequestDto;
import org.upcy.simbia.dto.response.EmployeeResponseDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/employees")
public interface EmployeeContract {

    @Operation(summary = "Create a new employee")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Employee created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeRequestDto dto);

    @Operation(summary = "List all employees")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List returned successfully")
    })
    @GetMapping
    ResponseEntity<List<EmployeeResponseDto>> listEmployees();

    @Operation(summary = "Get an employee by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employee found"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<EmployeeResponseDto> findEmployeeById(@PathVariable Long id);

    @Operation(summary = "Update an existing employee by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Employee updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeRequestDto dto);

    @Operation(summary = "Delete an employee by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Employee deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEmployee(@PathVariable Long id);
}
