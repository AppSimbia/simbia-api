package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.RoleDto;

import java.util.List;

@RequestMapping("/role")
public interface RoleContract {

    @Operation(summary = "Criar um novo cargo")
    @PostMapping
    ResponseEntity<RoleDto> create(@RequestBody RoleDto dto);

    @Operation(summary = "Listar todos os cargos")
    @GetMapping
    ResponseEntity<List<RoleDto>> findAll();

    @Operation(summary = "Listar um cargo")
    @GetMapping("/{id}")
    ResponseEntity<RoleDto> findById(@PathVariable Long id);

    @Operation(summary = "atualizar um cargo")
    @PutMapping("/{id}")
    ResponseEntity<RoleDto> update(@PathVariable Long id, @RequestBody RoleDto dto);

    @Operation(summary = "deletar um cargo")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
