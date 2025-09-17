package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.RoleEmployeeContract;
import org.upcy.simbia.dto.RoleEmployeeDto;
import org.upcy.simbia.model.RoleEmployee;
import org.upcy.simbia.service.RoleEmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleEmployeeController implements RoleEmployeeContract {

    private final RoleEmployeeService roleEmployeeService;

    @Override
    public ResponseEntity<RoleEmployee> create(RoleEmployeeDto dto) {
        return ResponseEntity.ok(roleEmployeeService.create(dto));
    }

    @Override
    public ResponseEntity<List<RoleEmployee>> findAll() {
        return ResponseEntity.ok(roleEmployeeService.findAll());
    }

    @Override
    public ResponseEntity<RoleEmployee> findById(Long id) {
        return ResponseEntity.ok(roleEmployeeService.findById(id));
    }

    @Override
    public ResponseEntity<RoleEmployee> update(Long id, RoleEmployeeDto dto) {
        return ResponseEntity.ok(roleEmployeeService.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        roleEmployeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
