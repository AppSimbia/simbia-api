package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.BenefitDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/benefits")
public interface BenefitContract {

    @Operation(summary = "Cria um novo benefício")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Benefício criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<BenefitDto> create(@Valid @RequestBody BenefitDto dto);

    @Operation(summary = "Retorna um benefício específico pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Benefício encontrado"),
            @ApiResponse(responseCode = "404", description = "Benefício não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<BenefitDto> findById(@PathVariable Long id);

    @Operation(summary = "Lista todos os benefícios")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de benefícios retornada com sucesso")
    })
    @GetMapping
    ResponseEntity<List<BenefitDto>> findAll();

    @Operation(summary = "Atualiza um benefício existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Benefício atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Benefício não encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<BenefitDto> update(@PathVariable Long id, @Valid @RequestBody BenefitDto dto);

    @Operation(summary = "Remove um benefício pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Benefício deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Benefício não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
