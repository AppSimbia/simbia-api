package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.IndustryDto;
import org.upcy.simbia.model.Industry;

import jakarta.validation.Valid;
import java.util.Optional;

@RequestMapping("/industries")
public interface IndustryContract {

    @Operation(summary = "Cria uma nova indústria")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Indústria criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<Industry> create(@Valid @RequestBody IndustryDto dto);

    @Operation(summary = "Retorna uma indústria pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Indústria encontrada"),
            @ApiResponse(responseCode = "404", description = "Indústria não encontrada")
    })
    @GetMapping("/{id}")
    ResponseEntity<Optional<Industry>> findById(@PathVariable Long id);

    @Operation(summary = "Atualiza uma indústria existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Indústria atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Indústria não encontrada")
    })
    @PutMapping("/{id}")
    ResponseEntity<Optional<Industry>> update(@PathVariable Long id, @Valid @RequestBody IndustryDto dto);

    @Operation(summary = "Remove uma indústria pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Indústria deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Indústria não encontrada")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
