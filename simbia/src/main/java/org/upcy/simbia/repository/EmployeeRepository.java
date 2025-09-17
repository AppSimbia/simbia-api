package org.upcy.simbia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upcy.simbia.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
