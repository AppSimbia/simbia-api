package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.ProductCategoryRequestDto;
import org.upcy.simbia.dto.response.ProductCategoryResponseDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/product-categories")
public interface ProductCategoryContract {

    @Operation(summary = "Create a new product category")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Category successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<ProductCategoryResponseDto> createProductCategory(@Valid @RequestBody ProductCategoryRequestDto dto);

    @Operation(summary = "List all product categories")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List returned successfully")
    })
    @GetMapping
    ResponseEntity<List<ProductCategoryResponseDto>> listProductCategories();

    @Operation(summary = "Get a product category by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Category found"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<ProductCategoryResponseDto> findProductCategoryById(@PathVariable Long id);

    @Operation(summary = "Update a product category by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Category updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<ProductCategoryResponseDto> updateProductCategory(@PathVariable Long id, @Valid @RequestBody ProductCategoryRequestDto dto);

    @Operation(summary = "Delete a product category by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Category deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteProductCategory(@PathVariable Long id);
}
