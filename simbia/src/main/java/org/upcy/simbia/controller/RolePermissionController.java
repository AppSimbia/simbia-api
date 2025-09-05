package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.contract.RolePermissionContract;
import org.upcy.simbia.dto.RolePermissionDto;
import org.upcy.simbia.model.RolePermission;
import org.upcy.simbia.service.RolePermissionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RolePermissionController implements RolePermissionContract {

    private final RolePermissionService rolePermissionService;

    @Override
    public ResponseEntity<RolePermission> create(RolePermissionDto dto) {
        return ResponseEntity.ok(rolePermissionService.create(dto));
    }

    @Override
    public ResponseEntity<List<RolePermission>> findAll() {
        return ResponseEntity.ok(rolePermissionService.findAll());
    }

    @Override
    public ResponseEntity<RolePermission> findById(Long id) {
        return ResponseEntity.ok(rolePermissionService.findById(id));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        rolePermissionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
