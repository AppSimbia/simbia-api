package org.upcy.simbia.service;

import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.EmployeeDto;
import org.upcy.simbia.model.Employee;
import org.upcy.simbia.model.Login;
import org.upcy.simbia.repository.EmployeeRepository;
import org.upcy.simbia.repository.LoginRepository;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final LoginRepository loginRepository;

    public EmployeeService(EmployeeRepository employeeRepository, LoginRepository loginRepository) {
        this.employeeRepository = employeeRepository;
        this.loginRepository = loginRepository;
    }

    public Employee create(EmployeeDto dto) {
        Employee employee = new Employee();
        employee.setEmployeeName(dto.getEmployeeName());
        employee.setLogin(getLogin(dto.getLogin()));
        employee.setActive("1");
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id)
                .filter(emp -> "1".equals(emp.getActive()));
    }

    public Optional<Employee> update(Long id, EmployeeDto dto) {
        return employeeRepository.findById(id).map(existing -> {
            existing.setEmployeeName(dto.getEmployeeName());
            existing.setLogin(getLogin(dto.getLogin()));
            return employeeRepository.save(existing);
        });
    }

    public boolean delete(Long id) {
        return employeeRepository.findById(id).map(existing -> {
            existing.setActive("0");
            employeeRepository.save(existing);
            return true;
        }).orElse(false);
    }

    private Login getLogin(Long id) {
        return loginRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Login não encontrado: " + id)
        );
    }
}
