package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.PostContract;
import org.upcy.simbia.dto.request.PostRequestDto;
import org.upcy.simbia.dto.response.PostResponseDto;
import org.upcy.simbia.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController implements PostContract {

    private final PostService postService;

    @Override
    public ResponseEntity<PostResponseDto> create(PostRequestDto dto) {
        return ResponseEntity.ok(postService.insertPost(dto));
    }

    @Override
    public ResponseEntity<List<PostResponseDto>> findAll() {
        return ResponseEntity.ok(postService.listPosts());
    }

    @Override
    public ResponseEntity<PostResponseDto> findById(Long id) {
        return ResponseEntity.ok(postService.findPost(id));
    }

    @Override
    public ResponseEntity<PostResponseDto> update(Long id, PostRequestDto dto) {
        return ResponseEntity.ok(postService.updatePost(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
