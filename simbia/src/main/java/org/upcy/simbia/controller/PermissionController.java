package org.upcy.simbia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.PermissionContract;
import org.upcy.simbia.dto.PermissionDto;
import org.upcy.simbia.service.PermissionService;

import java.util.List;

@RestController
public class PermissionController implements PermissionContract {

    private final PermissionService service;

    public PermissionController(PermissionService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<PermissionDto> create(PermissionDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @Override
    public ResponseEntity<List<PermissionDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<PermissionDto> findById(Long id) {
        PermissionDto dto = service.findById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<PermissionDto> update(Long id, PermissionDto dto) {
        PermissionDto updated = service.update(id, dto);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        boolean deleted = service.delete(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
