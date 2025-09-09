package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.RolePermissionDto;
import org.upcy.simbia.model.RolePermission;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/role-permissions")
public interface RolePermissionContract {

    @Operation(summary = "Cria uma nova associação entre cargo e permissão")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Associação criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<RolePermission> create(@Valid @RequestBody RolePermissionDto dto);

    @Operation(summary = "Lista todas as associações entre cargos e permissões")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping
    ResponseEntity<List<RolePermission>> findAll();

    @Operation(summary = "Retorna uma associação pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Associação encontrada"),
            @ApiResponse(responseCode = "404", description = "Associação não encontrada")
    })
    @GetMapping("/{id}")
    ResponseEntity<RolePermission> findById(@PathVariable Long id);

    @Operation(summary = "Remove uma associação pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Associação deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Associação não encontrada")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
