package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.PlanDto;
import org.upcy.simbia.model.Plan;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/plans")
public interface PlanContract {

    @Operation(summary = "Cria um novo plano")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Plano criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<Plan> create(@Valid @RequestBody PlanDto dto);

    @Operation(summary = "Lista todos os planos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de planos retornada com sucesso")
    })
    @GetMapping
    ResponseEntity<List<Plan>> findAll();

    @Operation(summary = "Retorna um plano pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Plano encontrado"),
            @ApiResponse(responseCode = "404", description = "Plano não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<Plan> findById(@PathVariable Long id);

    @Operation(summary = "Atualiza um plano existente pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Plano atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Plano não encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<Plan> update(@PathVariable Long id, @Valid @RequestBody PlanDto dto);

    @Operation(summary = "Remove um plano pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Plano deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Plano não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
