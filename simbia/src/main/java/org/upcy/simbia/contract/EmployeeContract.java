package org.upcy.simbia.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.EmployeeDto;
import org.upcy.simbia.model.Employee;

import java.util.Optional;

@RequestMapping("/employees")
public interface EmployeeContract {

    @PostMapping
    ResponseEntity<Employee> create(@RequestBody EmployeeDto dto);

    @GetMapping("/{id}")
    ResponseEntity<Optional<Employee>> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<Optional<Employee>> update(@PathVariable Long id, @RequestBody EmployeeDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
