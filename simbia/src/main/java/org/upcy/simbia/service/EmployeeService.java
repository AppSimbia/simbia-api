package org.upcy.simbia.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.EmployeeRequestDto;
import org.upcy.simbia.dto.response.EmployeeResponseDto;
import org.upcy.simbia.model.Employee;
import org.upcy.simbia.model.LoginIndustry;
import org.upcy.simbia.repository.EmployeeRepository;
import org.upcy.simbia.repository.LoginIndustryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final LoginIndustryRepository loginRepository;

    private EmployeeResponseDto toDto(Employee employee) {
        EmployeeResponseDto dto = new EmployeeResponseDto();
        dto.setEmployeeName(employee.getEmployeeName());
        return dto;
    }

    private LoginIndustry getLogin(Long id) {
        return loginRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("LoginIndustry not found: " + id));
    }

    public EmployeeResponseDto createEmployee(EmployeeRequestDto dto) {
        Employee employee = new Employee();
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setActive("1");
        employeeRepository.save(employee);
        return toDto(employee);
    }

    public EmployeeResponseDto findEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .filter(emp -> "1".equals(emp.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
        return toDto(employee);
    }

    @Transactional
    public EmployeeResponseDto updateEmployee(Long id, EmployeeRequestDto dto) {
        Employee employee = employeeRepository.findById(id)
                .filter(emp -> "1".equals(emp.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        employee.setEmployeeName(dto.getEmployeeName());
        employeeRepository.save(employee);
        return toDto(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .filter(emp -> "1".equals(emp.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        employee.setActive("0");
        employeeRepository.save(employee);
    }

    public List<EmployeeResponseDto> listEmployees() {
        return employeeRepository.findAll()
                .stream()
                .filter(emp -> "1".equals(emp.getActive()))
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
