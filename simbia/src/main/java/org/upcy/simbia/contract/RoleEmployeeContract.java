package org.upcy.simbia.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.RoleEmployeeDto;
import org.upcy.simbia.model.RoleEmployee;

import java.util.List;

@RequestMapping("/role-employees")
public interface RoleEmployeeContract {

    @PostMapping
    ResponseEntity<RoleEmployee> create(@RequestBody RoleEmployeeDto dto);

    @GetMapping
    ResponseEntity<List<RoleEmployee>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<RoleEmployee> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<RoleEmployee> update(@PathVariable Long id, @RequestBody RoleEmployeeDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
