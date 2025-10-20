package org.upcy.simbia.api.employee;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.api.employee.input.EmployeeRequestDto;
import org.upcy.simbia.api.employee.output.EmployeeResponseDto;

@RequestMapping("/employees")
public interface EmployeeContract {

    @Operation(summary = "Create a new employee")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Employee created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeRequestDto dto);

    @Operation(summary = "Update a employee")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Employee updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PutMapping("/{id}")
    ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable("id") Long id, @Valid @RequestBody EmployeeRequestDto dto);

    @Operation(summary = "Delete an employee by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Employee deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Employee not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteEmployee(@PathVariable Long id);
}
