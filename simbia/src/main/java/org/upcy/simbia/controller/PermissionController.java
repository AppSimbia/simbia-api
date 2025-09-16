package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.PermissionContract;
import org.upcy.simbia.dto.request.PermissionRequestDto;
import org.upcy.simbia.dto.response.PermissionResponseDto;
import org.upcy.simbia.service.PermissionService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PermissionController implements PermissionContract {

    private final PermissionService permissionService;

    @Override
    public ResponseEntity<PermissionResponseDto> createPermission(PermissionRequestDto dto) {
        return ResponseEntity.status(201).body(permissionService.createPermission(dto));
    }

    @Override
    public ResponseEntity<List<PermissionResponseDto>> listPermissions() {
        return ResponseEntity.ok(permissionService.listPermissions());
    }

    @Override
    public ResponseEntity<PermissionResponseDto> findPermissionById(Long id) {
        return ResponseEntity.ok(permissionService.findPermissionById(id));
    }

    @Override
    public ResponseEntity<PermissionResponseDto> updatePermission(Long id, PermissionRequestDto dto) {
        return ResponseEntity.ok(permissionService.updatePermission(id, dto));
    }

    @Override
    public ResponseEntity<Void> deletePermission(Long id) {
        permissionService.deletePermission(id);
        return ResponseEntity.noContent().build();
    }
}
