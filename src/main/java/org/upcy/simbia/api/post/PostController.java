package org.upcy.simbia.api.post;

import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.api.post.input.PostRequestDto;
import org.upcy.simbia.api.post.output.PostResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.ProductCategory;
import org.upcy.simbia.service.PostService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class PostController implements PostContract {

    private final PostService postService;

    @Override
    public ResponseEntity<PostResponseDto> create(PostRequestDto dto) {
        return ResponseEntity.ok(postService.save(dto));
    }

    @Override
    public ResponseEntity<List<PostResponseDto>> findAllByIndustry(String cnpj) {
        return ResponseEntity.ok(postService.findAllByIndustry(cnpj));
    }

    @Override
    public ResponseEntity<List<PostResponseDto>> findAllExceptIndustry(String cnpj) {
        return ResponseEntity.ok(postService.findAllExceptIndustry(cnpj));
    }

    @Override
    public ResponseEntity<List<PostResponseDto>> findAllIndustryByEmployee(Long id) {
        return ResponseEntity.ok(postService.findAllIndustryByEmployee(id));
    }


    @Override
    public ResponseEntity<List<ProductCategory>> findAllProductCategory() {
        return ResponseEntity.ok(postService.findAllProductCategory());
    }

    @Override
    public ResponseEntity<PostResponseDto> findById(Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @Override
    public ResponseEntity<PostResponseDto> update(Long id, Map<String, Object> map) throws JsonMappingException {
        return ResponseEntity.ok(postService.update(id, map));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
