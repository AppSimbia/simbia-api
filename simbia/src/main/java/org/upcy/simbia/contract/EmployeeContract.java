package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.EmployeeDto;
import org.upcy.simbia.model.Employee;

import jakarta.validation.Valid;
import java.util.Optional;

@RequestMapping("/employees")
public interface EmployeeContract {

    @Operation(summary = "Cria um novo colaborador")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Colaborador criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<Employee> create(@Valid @RequestBody EmployeeDto dto);

    @Operation(summary = "Retorna um colaborador pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Colaborador encontrado"),
            @ApiResponse(responseCode = "404", description = "Colaborador não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<Optional<Employee>> findById(@PathVariable Long id);

    @Operation(summary = "Atualiza um colaborador existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Colaborador atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Colaborador não encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<Optional<Employee>> update(@PathVariable Long id, @Valid @RequestBody EmployeeDto dto);

    @Operation(summary = "Remove um colaborador pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Colaborador deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Colaborador não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
