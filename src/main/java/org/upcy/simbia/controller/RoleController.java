package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.RoleContract;
import org.upcy.simbia.dto.request.RoleRequestDto;
import org.upcy.simbia.dto.response.RoleResponseDto;
import org.upcy.simbia.service.RoleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RoleController implements RoleContract {

    private final RoleService roleService;

    @Override
    public ResponseEntity<RoleResponseDto> createRole(RoleRequestDto dto) {
        return ResponseEntity.status(201).body(roleService.createRole(dto));
    }

    @Override
    public ResponseEntity<List<RoleResponseDto>> listRoles() {
        return ResponseEntity.ok(roleService.listRoles());
    }

    @Override
    public ResponseEntity<RoleResponseDto> findRoleById(Long id) {
        return ResponseEntity.ok(roleService.findRoleById(id));
    }

    @Override
    public ResponseEntity<RoleResponseDto> updateRole(Long id, RoleRequestDto dto) {
        return ResponseEntity.ok(roleService.updateRole(id, dto));
    }

    @Override
    public ResponseEntity<Void> deleteRole(Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
