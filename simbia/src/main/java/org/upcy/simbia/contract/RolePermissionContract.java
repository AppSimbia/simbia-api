package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.RolePermissionDto;
import org.upcy.simbia.model.RolePermission;

import java.util.List;

@RequestMapping("/role-permissions")
public interface RolePermissionContract {

    @PostMapping
    ResponseEntity<RolePermission> create(@RequestBody RolePermissionDto dto);

    @GetMapping
    ResponseEntity<List<RolePermission>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<RolePermission> findById(@PathVariable Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
