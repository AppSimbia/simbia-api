package org.upcy.simbia.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.upcy.simbia.api.post.input.PostRequestDto;
import org.upcy.simbia.api.post.output.PostResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.Employee;
import org.upcy.simbia.dataprovider.persistence.entity.Industry;
import org.upcy.simbia.dataprovider.persistence.entity.Post;
import org.upcy.simbia.dataprovider.persistence.entity.ProductCategory;
import org.upcy.simbia.dataprovider.persistence.repository.PostRepository;
import org.upcy.simbia.dataprovider.persistence.repository.ProductCategoryRepository;
import org.upcy.simbia.mapper.PostMapper;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostService implements CrudService<Post, Long, PostRequestDto, PostResponseDto> {

    private static final PostMapper postMapper = new PostMapper();
    private final IndustryService industryService;
    private final EmployeeService employeeService;
    private final PostRepository postRepository;
    private final ProductCategoryRepository productCategoryRepository;

    @Override
    public PostResponseDto save(PostRequestDto request) {
        Post post = toEntity(request);
        mapRelationships(post, request);
        post.setId(postRepository.generateId());
        return toResponse(postRepository.save(post));
    }

    @Cacheable("postsId")
    @Override
    public PostResponseDto findById(Long id) {
        return toResponse(findEntityById(id));
    }

    @Override
    public PostResponseDto update(Long id, Map<String, Object> map) throws JsonMappingException {
        Post post = findEntityById(id);
        postMapper.updateFromMap(post, map);
        return toResponse(postRepository.save(post));
    }

    @Override
    public void delete(Long id) {
        Post post = findEntityById(id);

        post.setActive("0");
        postRepository.save(post);
    }

    @Override
    public List<PostResponseDto> findAll() {
        return postRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public Post findEntityById(Long id) {
        return postRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Post not found"));
    }

    @Cacheable("posts")
    public List<PostResponseDto> findAllByIndustry(String cnpj) {
        return postRepository.findAllByIndustry(cnpj, "2").stream()
                .map(this::toResponse)
                .toList();
    }

    @Cacheable("postsExcept")
    public List<PostResponseDto> findAllExceptIndustry(String cnpj) {
        return postRepository.findAllExceptIndustry(cnpj, "2").stream()
                .map(this::toResponse)
                .toList();
    }

    @Cacheable("postsEmployee")
    public List<PostResponseDto> findAllIndustryByEmployee(Long id) {
        return postRepository.findAllIndustryByEmployee(id, "2").stream()
                .map(this::toResponse)
                .toList();
    }

    public List<Post> findAllSolicitationsByIndustry(String cnpj) {
        return postRepository.findAllByIndustry(cnpj, "1");
    }

    @Cacheable("categories")
    public List<ProductCategory> findAllProductCategory() {
        return productCategoryRepository.findAll();
    }

    private void mapRelationships(Post post, PostRequestDto dto) {
        ProductCategory productCategory = productCategoryRepository.findById(dto.getIdProductCategory())
                .orElseThrow(() -> new EntityNotFoundException("IndustryType not found: " + dto.getIdProductCategory()));
        Industry industry = industryService.findEntityById(dto.getIdIndustry());
        Employee employee = employeeService.findEntityById(dto.getIdEmployee());

        post.setIdProductCategory(productCategory);
        post.setIdIndustry(industry);
        post.setIdEmployee(employee);
    }

    private Post toEntity(PostRequestDto dto) {
        return postMapper.toEntity(dto);
    }

    private PostResponseDto toResponse(Post post) {
        return postMapper.toResponse(post);
    }
}
