package org.upcy.simbia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.ProductCategoryDto;
import org.upcy.simbia.model.ProductCategory;
import org.upcy.simbia.repository.ProductCategoryRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategory create(ProductCategoryDto dto) {
        ProductCategory category = new ProductCategory();
        category.setCategoryName(dto.getCategoryName());
        category.setInfo(dto.getInfo());
        category.setActive("1");
        return productCategoryRepository.save(category);
    }

    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll()
                .stream()
                .filter(cat -> "1".equals(cat.getActive()))
                .toList();
    }

    public ProductCategory findById(Long id) {
        return productCategoryRepository.findById(id)
                .filter(cat -> "1".equals(cat.getActive()))
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public ProductCategory update(Long id, ProductCategoryDto dto) {
        ProductCategory category = findById(id);
        category.setCategoryName(dto.getCategoryName());
        category.setInfo(dto.getInfo());
        return productCategoryRepository.save(category);
    }

    public void delete(Long id) {
        ProductCategory category = findById(id);
        if (!"0".equals(category.getActive())) {
            category.setActive("0");
            productCategoryRepository.save(category);
        }
    }
}
