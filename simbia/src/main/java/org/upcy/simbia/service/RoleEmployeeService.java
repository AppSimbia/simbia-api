package org.upcy.simbia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.RoleEmployeeDto;
import org.upcy.simbia.model.Employee;
import org.upcy.simbia.model.Role;
import org.upcy.simbia.model.RoleEmployee;
import org.upcy.simbia.repository.EmployeeRepository;
import org.upcy.simbia.repository.RoleEmployeeRepository;
import org.upcy.simbia.repository.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleEmployeeService {

    private final RoleEmployeeRepository roleEmployeeRepository;
    private final EmployeeRepository employeeRepository;
    private final RoleRepository roleRepository;

    public RoleEmployee create(RoleEmployeeDto dto) {
        Employee employee = employeeRepository.findById(dto.getEmployee())
                .orElseThrow(() -> new RuntimeException("Employee não encontrado"));

        Role role = roleRepository.findById(dto.getRole())
                .orElseThrow(() -> new RuntimeException("Role não encontrado"));

        RoleEmployee roleEmployee = new RoleEmployee();
        roleEmployee.setEmployee(employee);
        roleEmployee.setRole(role);

        return roleEmployeeRepository.save(roleEmployee);
    }

    public List<RoleEmployee> findAll() {
        return roleEmployeeRepository.findAll();
    }

    public RoleEmployee findById(Long id) {
        return roleEmployeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoleEmployee não encontrado"));
    }

    public RoleEmployee update(Long id, RoleEmployeeDto dto) {
        RoleEmployee existing = findById(id);

        Employee employee = employeeRepository.findById(dto.getEmployee())
                .orElseThrow(() -> new RuntimeException("Employee não encontrado"));

        Role role = roleRepository.findById(dto.getRole())
                .orElseThrow(() -> new RuntimeException("Role não encontrado"));

        existing.setEmployee(employee);
        existing.setRole(role);

        return roleEmployeeRepository.save(existing);
    }

    public void delete(Long id) {
        RoleEmployee existing = findById(id);
        roleEmployeeRepository.delete(existing);
    }
}
