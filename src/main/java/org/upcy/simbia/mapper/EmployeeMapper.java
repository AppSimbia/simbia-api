package org.upcy.simbia.mapper;

import org.upcy.simbia.api.employee.input.EmployeeRequestDto;
import org.upcy.simbia.api.employee.output.EmployeeResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.Employee;

public class EmployeeMapper extends AbstractMapper<Employee, EmployeeRequestDto, EmployeeResponseDto> {

    @Override
    public Employee toEntity(EmployeeRequestDto requestDto) {
        return null;
    }

    @Override
    public EmployeeResponseDto toResponse(Employee entity) {
        return EmployeeResponseDto.builder()
                .idEmployee(entity.getIdEmployee())
                .employeeName(entity.getEmployeeName())
                .build();
    }
}
