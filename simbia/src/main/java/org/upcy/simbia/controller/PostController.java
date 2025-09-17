package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.PostContract;
import org.upcy.simbia.dto.PostDto;
import org.upcy.simbia.model.Post;
import org.upcy.simbia.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController implements PostContract {

    private final PostService postService;

    @Override
    public ResponseEntity<Post> create(PostDto dto) {
        return ResponseEntity.ok(postService.create(dto));
    }

    @Override
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    @Override
    public ResponseEntity<Post> findById(Long id) {
        return ResponseEntity.ok(postService.findById(id));
    }

    @Override
    public ResponseEntity<Post> update(Long id, PostDto dto) {
        return ResponseEntity.ok(postService.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
