package org.upcy.simbia.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.PostDto;
import org.upcy.simbia.model.Post;

import java.util.List;

@RequestMapping("/posts")
public interface PostContract {

    @PostMapping
    ResponseEntity<Post> create(@RequestBody PostDto dto);

    @GetMapping
    ResponseEntity<List<Post>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<Post> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<Post> update(@PathVariable Long id, @RequestBody PostDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
