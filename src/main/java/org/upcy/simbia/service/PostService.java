package org.upcy.simbia.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.PostRequestDto;
import org.upcy.simbia.dto.response.PostResponseDto;
import org.upcy.simbia.model.*;
import org.upcy.simbia.repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final IndustryRepository industryRepository;
    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper;

    private PostResponseDto toDto(Post entity) {
        return objectMapper.convertValue(entity, PostResponseDto.class);
    }

    private ProductCategory getProductCategory(Long id) {
        return productCategoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product category not found"));
    }

    private Industry getIndustry(Long id) {
        return industryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Industry not found"));
    }

    private Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    public List<PostResponseDto> listPosts() {
        return postRepository.findAll()
                .stream()
                .filter(p -> "1".equals(p.getActive()))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public PostResponseDto findPost(Long id) {
        Post post = postRepository.findById(id)
                .filter(p -> "1".equals(p.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
        return toDto(post);
    }

    public PostResponseDto insertPost(@Valid PostRequestDto dto) {
        ProductCategory category = getProductCategory(dto.getIdProductCategory());
        Industry industry = getIndustry(dto.getIdIndustry());
        Employee employee = getEmployee(dto.getIdEmployee());

        Post entity = new Post();
        entity.setIdProductCategory(category);
        entity.setIdIndustry(industry);
        entity.setIdEmployee(employee);
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setQuantity(dto.getQuantity());
        entity.setMeasureUnit(dto.getMeasureUnit());
        entity.setImage(dto.getImage());
        entity.setPublicationDate(dto.getPublicationDate());
        entity.setActive("1");

        postRepository.save(entity);
        return toDto(entity);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, @Valid PostRequestDto dto) {
        Post existing = postRepository.findById(id)
                .filter(p -> "1".equals(p.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));

        ProductCategory category = getProductCategory(dto.getIdProductCategory());
        Industry industry = getIndustry(dto.getIdIndustry());
        Employee employee = getEmployee(dto.getIdEmployee());

        existing.setIdProductCategory(category);
        existing.setIdIndustry(industry);
        existing.setIdEmployee(employee);
        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setQuantity(dto.getQuantity());
        existing.setMeasureUnit(dto.getMeasureUnit());
        existing.setImage(dto.getImage());
        existing.setPublicationDate(dto.getPublicationDate());

        postRepository.save(existing);
        return toDto(existing);
    }

    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));

        post.setActive("0");
        postRepository.save(post);
    }
}
