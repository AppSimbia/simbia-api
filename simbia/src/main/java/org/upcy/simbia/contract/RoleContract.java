package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.RoleDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/role")
public interface RoleContract {

    @Operation(summary = "Cria um novo cargo")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cargo criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<RoleDto> create(@Valid @RequestBody RoleDto dto);

    @Operation(summary = "Lista todos os cargos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de cargos retornada com sucesso")
    })
    @GetMapping
    ResponseEntity<List<RoleDto>> findAll();

    @Operation(summary = "Retorna um cargo pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cargo encontrado"),
            @ApiResponse(responseCode = "404", description = "Cargo não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<RoleDto> findById(@PathVariable Long id);

    @Operation(summary = "Atualiza um cargo existente pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cargo atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Cargo não encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<RoleDto> update(@PathVariable Long id, @Valid @RequestBody RoleDto dto);

    @Operation(summary = "Remove um cargo pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Cargo deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cargo não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
