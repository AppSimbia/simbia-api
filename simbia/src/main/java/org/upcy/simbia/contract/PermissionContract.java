package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.PermissionDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/permissions")
public interface PermissionContract {

    @Operation(summary = "Cria uma nova permissão")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Permissão criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<PermissionDto> create(@Valid @RequestBody PermissionDto dto);

    @Operation(summary = "Lista todas as permissões")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de permissões retornada com sucesso")
    })
    @GetMapping
    ResponseEntity<List<PermissionDto>> findAll();

    @Operation(summary = "Retorna uma permissão pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Permissão encontrada"),
            @ApiResponse(responseCode = "404", description = "Permissão não encontrada")
    })
    @GetMapping("/{id}")
    ResponseEntity<PermissionDto> findById(@PathVariable Long id);

    @Operation(summary = "Atualiza uma permissão existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Permissão atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Permissão não encontrada")
    })
    @PutMapping("/{id}")
    ResponseEntity<PermissionDto> update(@PathVariable Long id, @Valid @RequestBody PermissionDto dto);

    @Operation(summary = "Remove uma permissão pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Permissão deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Permissão não encontrada")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
