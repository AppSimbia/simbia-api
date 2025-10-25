package org.upcy.simbia.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.api.employee.input.EmployeeRequestDto;
import org.upcy.simbia.api.employee.output.EmployeeResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.Employee;
import org.upcy.simbia.dataprovider.persistence.repository.EmployeeRepository;
import org.upcy.simbia.mapper.EmployeeMapper;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private static final EmployeeMapper employeeMapper = new EmployeeMapper();
    private final EmployeeRepository employeeRepository;
    private final IndustryService industryService;

    public EmployeeResponseDto save(EmployeeRequestDto dto) {
        Employee employee = Employee.builder()
                .idEmployee(employeeRepository.generateId())
                .employeeName(dto.getEmployeeName())
                .industry(industryService.findEntityById(dto.getIdIndustry()))
                .active("1")
                .build();
        employeeRepository.save(employee);
        return toResponse(employee);
    }

    @Transactional
    public EmployeeResponseDto update(Long id, EmployeeRequestDto dto) {
        Employee employee = findEntityById(id);

        employee.setEmployeeName(dto.getEmployeeName());
        employeeRepository.save(employee);
        return toResponse(employee);
    }

    public void delete(Long id) {
        Employee employee = findEntityById(id);

        employee.setActive("0");
        employeeRepository.save(employee);
    }

    public Employee findEntityById(Long id) {
        return employeeRepository.findById(id)
                .filter(emp -> "1".equals(emp.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    private EmployeeResponseDto toResponse(Employee employee) {
        return employeeMapper.toResponse(employee);
    }

}
