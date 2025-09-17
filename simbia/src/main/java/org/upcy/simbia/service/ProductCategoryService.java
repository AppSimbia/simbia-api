package org.upcy.simbia.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.ProductCategoryRequestDto;
import org.upcy.simbia.dto.response.ProductCategoryResponseDto;
import org.upcy.simbia.model.ProductCategory;
import org.upcy.simbia.repository.ProductCategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    private ProductCategoryResponseDto toDto(ProductCategory entity) {
        ProductCategoryResponseDto dto = new ProductCategoryResponseDto();
        dto.setCategoryName(entity.getCategoryName());
        dto.setInfo(entity.getInfo());
        return dto;
    }

    public List<ProductCategoryResponseDto> listProductCategories() {
        return productCategoryRepository.findAll()
                .stream()
                .filter(cat -> "1".equals(cat.getActive()))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public ProductCategoryResponseDto findProductCategoryById(Long id) {
        ProductCategory category = productCategoryRepository.findById(id)
                .filter(cat -> "1".equals(cat.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("Product category not found"));
        return toDto(category);
    }

    public ProductCategoryResponseDto createProductCategory(ProductCategoryRequestDto dto) {
        ProductCategory category = new ProductCategory();
        category.setCategoryName(dto.getCategoryName());
        category.setInfo(dto.getInfo());
        category.setActive("1");
        productCategoryRepository.save(category);
        return toDto(category);
    }

    @Transactional
    public ProductCategoryResponseDto updateProductCategory(Long id, ProductCategoryRequestDto dto) {
        ProductCategory category = productCategoryRepository.findById(id)
                .filter(cat -> "1".equals(cat.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("Product category not found"));

        category.setCategoryName(dto.getCategoryName());
        category.setInfo(dto.getInfo());

        productCategoryRepository.save(category);
        return toDto(category);
    }

    public void deleteProductCategory(Long id) {
        ProductCategory category = productCategoryRepository.findById(id)
                .filter(cat -> "1".equals(cat.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("Product category not found"));

        category.setActive("0");
        productCategoryRepository.save(category);
    }
}
