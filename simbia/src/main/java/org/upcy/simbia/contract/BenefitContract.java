package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.BenefitDto;

import java.util.List;

@RequestMapping("/benefits")
public interface BenefitContract {

    @Operation(summary = "Cria um novo beneficio")
    @PostMapping
    ResponseEntity<BenefitDto> create(@RequestBody BenefitDto dto);

    @Operation(summary = "Lista um beneficio especifico")
    @GetMapping("/{id}")
    ResponseEntity<BenefitDto> findById(@PathVariable Long id);

    @Operation(summary = "Lista todos os beneficios")
    @GetMapping
    ResponseEntity<List<BenefitDto>> findAll();

    @Operation(summary = "Atualiza um benefico")
    @PutMapping("/{id}")
    ResponseEntity<BenefitDto> update(@PathVariable Long id, @RequestBody BenefitDto dto);

    @Operation(summary = "Deleta um beneficio")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
