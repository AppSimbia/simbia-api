package org.upcy.simbia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.EmployeeContract;
import org.upcy.simbia.dto.EmployeeDto;
import org.upcy.simbia.model.Employee;
import org.upcy.simbia.service.EmployeeService;

import java.util.Optional;

@RestController
public class EmployeeController implements EmployeeContract {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<Employee> create(EmployeeDto dto) {
        return ResponseEntity.ok(employeeService.create(dto));
    }

    @Override
    public ResponseEntity<Optional<Employee>> findById(Long id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @Override
    public ResponseEntity<Optional<Employee>> update(Long id, EmployeeDto dto) {
        return ResponseEntity.ok(employeeService.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        boolean deleted = employeeService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
