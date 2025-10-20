package org.upcy.simbia.dataprovider.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.upcy.simbia.dataprovider.persistence.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT FN_TableIdGenerator('employee', 'idemployee')", nativeQuery = true)
    Long generateId();
}
