package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.ProductCategoryDto;
import org.upcy.simbia.model.ProductCategory;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/product-categories")
public interface ProductCategoryContract {

    @Operation(summary = "Cria uma nova categoria de produto")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Categoria criada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<ProductCategory> create(@Valid @RequestBody ProductCategoryDto dto);

    @Operation(summary = "Lista todas as categorias de produto")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de categorias retornada com sucesso")
    })
    @GetMapping
    ResponseEntity<List<ProductCategory>> findAll();

    @Operation(summary = "Retorna uma categoria de produto pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Categoria encontrada"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    @GetMapping("/{id}")
    ResponseEntity<ProductCategory> findById(@PathVariable Long id);

    @Operation(summary = "Atualiza uma categoria de produto existente pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Categoria atualizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    @PutMapping("/{id}")
    ResponseEntity<ProductCategory> update(@PathVariable Long id, @Valid @RequestBody ProductCategoryDto dto);

    @Operation(summary = "Remove uma categoria de produto pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Categoria deletada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
