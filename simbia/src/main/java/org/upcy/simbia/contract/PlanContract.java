package org.upcy.simbia.contract;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.PlanDto;
import org.upcy.simbia.model.Plan;

import java.util.List;

@Tag(name = "Plans", description = "Operações relacionadas a planos")
@RequestMapping("/plans")
public interface PlanContract {

    @Operation(summary = "Cria um novo plano")
    @PostMapping
    ResponseEntity<Plan> create(@RequestBody PlanDto dto);

    @Operation(summary = "Lista todos os planos")
    @GetMapping
    ResponseEntity<List<Plan>> findAll();

    @Operation(summary = "Busca plano pelo ID")
    @GetMapping("/{id}")
    ResponseEntity<Plan> findById(@PathVariable Long id);

    @Operation(summary = "Atualiza plano pelo ID")
    @PutMapping("/{id}")
    ResponseEntity<Plan> update(@PathVariable Long id, @RequestBody PlanDto dto);

    @Operation(summary = "Deleta plano pelo ID")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}

