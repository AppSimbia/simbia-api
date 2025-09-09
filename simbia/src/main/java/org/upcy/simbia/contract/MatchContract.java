package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.MatchDto;
import org.upcy.simbia.model.Match;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/matches")
public interface MatchContract {

    @Operation(summary = "Cria uma nova correspondência")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Match criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<Match> create(@Valid @RequestBody MatchDto dto);

    @Operation(summary = "Lista todas as correspondências")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de matches retornada com sucesso")
    })
    @GetMapping
    ResponseEntity<List<Match>> findAll();

    @Operation(summary = "Retorna uma correspondência pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Match encontrado"),
            @ApiResponse(responseCode = "404", description = "Match não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<Match> findById(@PathVariable Long id);

    @Operation(summary = "Atualiza uma correspondência existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Match atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Match não encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<Match> update(@PathVariable Long id, @Valid @RequestBody MatchDto dto);

    @Operation(summary = "Remove uma correspondência pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Match deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Match não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Atualiza o status de uma correspondência")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Status do match atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Match não encontrado")
    })
    @PatchMapping("/{id}/status")
    ResponseEntity<Match> updateStatus(@PathVariable Long id, @RequestParam String status);
}
