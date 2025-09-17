package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.EmployeeContract;
import org.upcy.simbia.dto.request.EmployeeRequestDto;
import org.upcy.simbia.dto.response.EmployeeResponseDto;
import org.upcy.simbia.service.EmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController implements EmployeeContract {

    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<EmployeeResponseDto> createEmployee(EmployeeRequestDto dto) {
        return ResponseEntity.status(201).body(employeeService.createEmployee(dto));
    }

    @Override
    public ResponseEntity<EmployeeResponseDto> findEmployeeById(Long id) {
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }

    @Override
    public ResponseEntity<EmployeeResponseDto> updateEmployee(Long id, EmployeeRequestDto dto) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, dto));
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<EmployeeResponseDto>> listEmployees() {
        return ResponseEntity.ok(employeeService.listEmployees());
    }
}
