package org.upcy.simbia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.PostDto;
import org.upcy.simbia.model.*;
import org.upcy.simbia.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final IndustryRepository industryRepository;
    private final EmployeeRepository employeeRepository;

    public Post create(PostDto dto) {
        ProductCategory category = productCategoryRepository.findById(dto.getProductCategory())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Industry industry = industryRepository.findById(dto.getIndustry())
                .orElseThrow(() -> new RuntimeException("Indústria não encontrada"));

        Employee employee = employeeRepository.findById(dto.getEmployee())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        Post post = new Post();
        post.setProductCategory(category);
        post.setIndustry(industry);
        post.setEmployee(employee);
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setQuantity(dto.getQuantity());
        post.setMeasureUnit(dto.getMeasureUnit());
        post.setImage(dto.getImage());
        post.setPublicationDate(dto.getPublicationDate());
        post.setActive("1");

        return postRepository.save(post);
    }

    public List<Post> findAll() {
        return postRepository.findAll()
                .stream()
                .filter(p -> "1".equals(p.getActive()))
                .toList();
    }

    public Post findById(Long id) {
        return postRepository.findById(id)
                .filter(p -> "1".equals(p.getActive()))
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));
    }

    public Post update(Long id, PostDto dto) {
        Post post = findById(id);

        ProductCategory category = productCategoryRepository.findById(dto.getProductCategory())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Industry industry = industryRepository.findById(dto.getIndustry())
                .orElseThrow(() -> new RuntimeException("Indústria não encontrada"));

        Employee employee = employeeRepository.findById(dto.getEmployee())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        post.setProductCategory(category);
        post.setIndustry(industry);
        post.setEmployee(employee);
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setQuantity(dto.getQuantity());
        post.setMeasureUnit(dto.getMeasureUnit());
        post.setImage(dto.getImage());
        post.setPublicationDate(dto.getPublicationDate());

        return postRepository.save(post);
    }

    public void delete(Long id) {
        Post post = findById(id);
        if (!"0".equals(post.getActive())) {
            post.setActive("0");
            postRepository.save(post);
        }
    }
}
