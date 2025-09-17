package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.ProductCategoryContract;
import org.upcy.simbia.dto.request.ProductCategoryRequestDto;
import org.upcy.simbia.dto.response.ProductCategoryResponseDto;
import org.upcy.simbia.service.ProductCategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductCategoryController implements ProductCategoryContract {

    private final ProductCategoryService productCategoryService;

    @Override
    public ResponseEntity<ProductCategoryResponseDto> createProductCategory(ProductCategoryRequestDto dto) {
        return ResponseEntity.status(201).body(productCategoryService.createProductCategory(dto));
    }

    @Override
    public ResponseEntity<List<ProductCategoryResponseDto>> listProductCategories() {
        return ResponseEntity.ok(productCategoryService.listProductCategories());
    }

    @Override
    public ResponseEntity<ProductCategoryResponseDto> findProductCategoryById(Long id) {
        return ResponseEntity.ok(productCategoryService.findProductCategoryById(id));
    }

    @Override
    public ResponseEntity<ProductCategoryResponseDto> updateProductCategory(Long id, ProductCategoryRequestDto dto) {
        return ResponseEntity.ok(productCategoryService.updateProductCategory(id, dto));
    }

    @Override
    public ResponseEntity<Void> deleteProductCategory(Long id) {
        productCategoryService.deleteProductCategory(id);
        return ResponseEntity.noContent().build();
    }
}
