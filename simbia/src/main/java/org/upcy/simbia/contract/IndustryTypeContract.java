package org.upcy.simbia.contract;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.IndustryTypeDto;

import java.util.List;

@RequestMapping("/industry-type")
public interface IndustryTypeContract {

    @Operation(summary = "Cria um novo tipo de empresa")
    @PostMapping
    ResponseEntity<IndustryTypeDto> create(@RequestBody IndustryTypeDto dto);

    @Operation(summary = "Lista um tipo de empresa especifico")
    @GetMapping("/{id}")
    ResponseEntity<IndustryTypeDto> findById(@PathVariable Long id);

    @Operation(summary = "Lista todos os tipo de empresas")
    @GetMapping
    ResponseEntity<List<IndustryTypeDto>> findAll();

    @Operation(summary = "Atualiza um benefico")
    @PutMapping("/{id}")
    ResponseEntity<IndustryTypeDto> update(@PathVariable Long id, @RequestBody IndustryTypeDto dto);

    @Operation(summary = "Deleta um tipo de empresa")
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
