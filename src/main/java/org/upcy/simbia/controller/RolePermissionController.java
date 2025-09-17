package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.RolePermissionContract;
import org.upcy.simbia.dto.request.RolePermissionRequestDto;
import org.upcy.simbia.dto.response.RolePermissionResponseDto;
import org.upcy.simbia.service.RolePermissionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RolePermissionController implements RolePermissionContract {

    private final RolePermissionService rolePermissionService;

    @Override
    public ResponseEntity<RolePermissionResponseDto> createRolePermission(RolePermissionRequestDto dto) {
        return ResponseEntity.status(201).body(rolePermissionService.createRolePermission(dto));
    }

    @Override
    public ResponseEntity<List<RolePermissionResponseDto>> listRolePermissions() {
        return ResponseEntity.ok(rolePermissionService.listRolePermissions());
    }

    @Override
    public ResponseEntity<RolePermissionResponseDto> findRolePermissionById(Long id) {
        return ResponseEntity.ok(rolePermissionService.findRolePermissionById(id));
    }

    @Override
    public ResponseEntity<Void> deleteRolePermission(Long id) {
        rolePermissionService.deleteRolePermission(id);
        return ResponseEntity.noContent().build();
    }
}
