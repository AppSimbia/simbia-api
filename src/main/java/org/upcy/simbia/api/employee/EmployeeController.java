package org.upcy.simbia.api.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.api.employee.input.EmployeeRequestDto;
import org.upcy.simbia.api.employee.output.EmployeeResponseDto;
import org.upcy.simbia.service.EmployeeService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class EmployeeController implements EmployeeContract {

    private final EmployeeService employeeService;

    @Override
    public ResponseEntity<EmployeeResponseDto> createEmployee(EmployeeRequestDto dto) {
        return ResponseEntity.status(201).body(employeeService.save(dto));
    }

    @Override
    public ResponseEntity<EmployeeResponseDto> findEmployeeById(Long id) {
        return ResponseEntity.status(200).body(employeeService.findById(id));
    }

    @Override
    public ResponseEntity<EmployeeResponseDto> updateEmployee(Long id, Map<String, Object> map) {
        return ResponseEntity.status(200).body(employeeService.update(id, map));
    }

    @Override
    public ResponseEntity<Void> deleteEmployee(Long id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
