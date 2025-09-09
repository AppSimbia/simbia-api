package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.BenefitPlanDto;
import org.upcy.simbia.model.BenefitPlan;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/benefit-plans")
public interface BenefitPlanContract {

    @Operation(summary = "Cria um novo plano de benefício")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Plano de benefício criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<BenefitPlan> create(@Valid @RequestBody BenefitPlanDto dto);

    @Operation(summary = "Lista todos os planos de benefício")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de planos de benefício retornada com sucesso")
    })
    @GetMapping
    ResponseEntity<List<BenefitPlan>> findAll();

    @Operation(summary = "Retorna um plano de benefício específico pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Plano de benefício encontrado"),
            @ApiResponse(responseCode = "404", description = "Plano de benefício não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<BenefitPlan> findById(@PathVariable Long id);

    @Operation(summary = "Remove um plano de benefício pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Plano de benefício deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Plano de benefício não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
