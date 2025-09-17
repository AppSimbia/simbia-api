package org.upcy.simbia.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.RoleEmployeeRequestDto;
import org.upcy.simbia.dto.response.RoleEmployeeResponseDto;
import org.upcy.simbia.model.Employee;
import org.upcy.simbia.model.Role;
import org.upcy.simbia.model.RoleEmployee;
import org.upcy.simbia.repository.EmployeeRepository;
import org.upcy.simbia.repository.RoleEmployeeRepository;
import org.upcy.simbia.repository.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleEmployeeService {

    private final RoleEmployeeRepository roleEmployeeRepository;
    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;

    private RoleEmployeeResponseDto toDto(RoleEmployee entity) {
        RoleEmployeeResponseDto dto = new RoleEmployeeResponseDto();
        dto.setIdRole(entity.getIdRole().getIdRole());
        dto.setIdEmployee(entity.getIdEmployee().getIdEmployee());
        return dto;
    }

    private Role getRole(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));
    }

    private Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    public List<RoleEmployeeResponseDto> listRoleEmployees() {
        return roleEmployeeRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public RoleEmployeeResponseDto findRoleEmployeeById(Long id) {
        RoleEmployee entity = roleEmployeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("RoleEmployee not found"));
        return toDto(entity);
    }

    public RoleEmployeeResponseDto createRoleEmployee(RoleEmployeeRequestDto dto) {
        Role role = getRole(dto.getIdRole());
        Employee employee = getEmployee(dto.getIdEmployee());

        RoleEmployee entity = new RoleEmployee();
        entity.setIdRole(role);
        entity.setIdEmployee(employee);

        roleEmployeeRepository.save(entity);
        return toDto(entity);
    }

    @Transactional
    public RoleEmployeeResponseDto updateRoleEmployee(Long id, RoleEmployeeRequestDto dto) {
        RoleEmployee existing = roleEmployeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("RoleEmployee not found"));

        existing.setIdRole(getRole(dto.getIdRole()));
        existing.setIdEmployee(getEmployee(dto.getIdEmployee()));

        roleEmployeeRepository.save(existing);
        return toDto(existing);
    }

    public void deleteRoleEmployee(Long id) {
        RoleEmployee existing = roleEmployeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("RoleEmployee not found"));
        roleEmployeeRepository.delete(existing);
    }
}
