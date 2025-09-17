package org.upcy.simbia.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.ProductCategoryDto;
import org.upcy.simbia.model.ProductCategory;

import java.util.List;

@RequestMapping("/product-categories")
public interface ProductCategoryContract {

    @PostMapping
    ResponseEntity<ProductCategory> create(@RequestBody ProductCategoryDto dto);

    @GetMapping
    ResponseEntity<List<ProductCategory>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<ProductCategory> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<ProductCategory> update(@PathVariable Long id, @RequestBody ProductCategoryDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
