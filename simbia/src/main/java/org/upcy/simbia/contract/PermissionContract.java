package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.PermissionDto;

import java.util.List;

@RequestMapping("/permissions")
public interface PermissionContract {

    @Operation(summary = "Criar uma nova permissao")
    @PostMapping
    ResponseEntity<PermissionDto> create(@RequestBody PermissionDto dto);

    @Operation(summary = "Listar todas as permissoes")
    @GetMapping
    ResponseEntity<List<PermissionDto>> findAll();

    @Operation(summary = "Listar uma permissao")
    @GetMapping("/{id}")
    ResponseEntity<PermissionDto> findById(@PathVariable Long id);

    @Operation(summary = "atualizar uma permissao")
    @PutMapping("/{id}")
    ResponseEntity<PermissionDto> update(@PathVariable Long id, @RequestBody PermissionDto dto);

    @Operation(summary = "deletar uma permissao")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
