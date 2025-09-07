package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.ProductCategoryContract;
import org.upcy.simbia.dto.ProductCategoryDto;
import org.upcy.simbia.model.ProductCategory;
import org.upcy.simbia.service.ProductCategoryService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductCategoryController implements ProductCategoryContract {

    private final ProductCategoryService productCategoryService;

    @Override
    public ResponseEntity<ProductCategory> create(ProductCategoryDto dto) {
        return ResponseEntity.ok(productCategoryService.create(dto));
    }

    @Override
    public ResponseEntity<List<ProductCategory>> findAll() {
        return ResponseEntity.ok(productCategoryService.findAll());
    }

    @Override
    public ResponseEntity<ProductCategory> findById(Long id) {
        return ResponseEntity.ok(productCategoryService.findById(id));
    }

    @Override
    public ResponseEntity<ProductCategory> update(Long id, ProductCategoryDto dto) {
        return ResponseEntity.ok(productCategoryService.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        productCategoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
