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

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeService implements CrudService<Employee, Long, EmployeeRequestDto, EmployeeResponseDto> {

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

    @Override
    public EmployeeResponseDto findById(Long id) {
        return toResponse(findEntityById(id));
    }

    @Transactional
    public EmployeeResponseDto update(Long id, Map<String, Object> map) {
        Employee employee = findEntityById(id);

        employee.setEmployeeName(map.get("employeeName").toString());
        employeeRepository.save(employee);
        return toResponse(employee);
    }

    public void delete(Long id) {
        Employee employee = findEntityById(id);

        employee.setActive("0");
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeResponseDto> findAll() {
        return List.of();
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
