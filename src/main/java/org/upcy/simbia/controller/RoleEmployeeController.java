package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.RoleEmployeeContract;
import org.upcy.simbia.dto.request.RoleEmployeeRequestDto;
import org.upcy.simbia.dto.response.RoleEmployeeResponseDto;
import org.upcy.simbia.service.RoleEmployeeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleEmployeeController implements RoleEmployeeContract {

    private final RoleEmployeeService roleEmployeeService;

    @Override
    public ResponseEntity<RoleEmployeeResponseDto> createRoleEmployee(RoleEmployeeRequestDto dto) {
        return ResponseEntity.status(201).body(roleEmployeeService.createRoleEmployee(dto));
    }

    @Override
    public ResponseEntity<List<RoleEmployeeResponseDto>> listRoleEmployees() {
        return ResponseEntity.ok(roleEmployeeService.listRoleEmployees());
    }

    @Override
    public ResponseEntity<RoleEmployeeResponseDto> findRoleEmployeeById(Long id) {
        return ResponseEntity.ok(roleEmployeeService.findRoleEmployeeById(id));
    }

    @Override
    public ResponseEntity<RoleEmployeeResponseDto> updateRoleEmployee(Long id, RoleEmployeeRequestDto dto) {
        return ResponseEntity.ok(roleEmployeeService.updateRoleEmployee(id, dto));
    }

    @Override
    public ResponseEntity<Void> deleteRoleEmployee(Long id) {
        roleEmployeeService.deleteRoleEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
