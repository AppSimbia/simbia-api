package org.upcy.simbia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.RoleContract;
import org.upcy.simbia.dto.RoleDto;
import org.upcy.simbia.service.RoleService;

import java.util.List;

@RestController
public class RoleController implements RoleContract {

    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<RoleDto> create(RoleDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @Override
    public ResponseEntity<List<RoleDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<RoleDto> findById(Long id) {
        RoleDto dto = service.findById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<RoleDto> update(Long id, RoleDto dto) {
        RoleDto updated = service.update(id, dto);
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
