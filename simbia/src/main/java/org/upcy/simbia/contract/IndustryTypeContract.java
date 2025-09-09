package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.IndustryTypeDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/industry-type")
public interface IndustryTypeContract {

    @Operation(summary = "Cria um novo tipo de empresa")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Tipo de empresa criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<IndustryTypeDto> create(@Valid @RequestBody IndustryTypeDto dto);

    @Operation(summary = "Retorna um tipo de empresa específico pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tipo de empresa encontrado"),
            @ApiResponse(responseCode = "404", description = "Tipo de empresa não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<IndustryTypeDto> findById(@PathVariable Long id);

    @Operation(summary = "Lista todos os tipos de empresa")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de tipos de empresa retornada com sucesso")
    })
    @GetMapping
    ResponseEntity<List<IndustryTypeDto>> findAll();

    @Operation(summary = "Atualiza um tipo de empresa existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Tipo de empresa atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Tipo de empresa não encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<IndustryTypeDto> update(@PathVariable Long id, @Valid @RequestBody IndustryTypeDto dto);

    @Operation(summary = "Remove um tipo de empresa pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Tipo de empresa deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Tipo de empresa não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
