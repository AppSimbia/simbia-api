package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.RoleEmployeeDto;
import org.upcy.simbia.model.RoleEmployee;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/role-employees")
public interface RoleEmployeeContract {

    @Operation(summary = "Cria uma nova associação entre cargo e colaborador")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Associação criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<RoleEmployee> create(@Valid @RequestBody RoleEmployeeDto dto);

    @Operation(summary = "Lista todas as associações entre cargos e colaboradores")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping
    ResponseEntity<List<RoleEmployee>> findAll();

    @Operation(summary = "Retorna uma associação pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Associação encontrada"),
            @ApiResponse(responseCode = "404", description = "Associação não encontrada")
    })
    @GetMapping("/{id}")
    ResponseEntity<RoleEmployee> findById(@PathVariable Long id);

    @Operation(summary = "Atualiza uma associação existente pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Associação atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Associação não encontrada")
    })
    @PutMapping("/{id}")
    ResponseEntity<RoleEmployee> update(@PathVariable Long id, @Valid @RequestBody RoleEmployeeDto dto);

    @Operation(summary = "Remove uma associação pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Associação deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Associação não encontrada")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
