package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.request.PostRequestDto;
import org.upcy.simbia.dto.response.PostResponseDto;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/posts")
public interface PostContract {

    @Operation(summary = "Create a new post")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Post successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<PostResponseDto> create(@Valid @RequestBody PostRequestDto dto);

    @Operation(summary = "List all posts")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of posts successfully returned")
    })
    @GetMapping
    ResponseEntity<List<PostResponseDto>> findAll();

    @Operation(summary = "Get a post by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Post found"),
            @ApiResponse(responseCode = "404", description = "Post not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<PostResponseDto> findById(@PathVariable Long id);

    @Operation(summary = "Update an existing post by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Post successfully updated"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided"),
            @ApiResponse(responseCode = "404", description = "Post not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<PostResponseDto> update(@PathVariable Long id, @Valid @RequestBody PostRequestDto dto);

    @Operation(summary = "Delete a post by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Post successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Post not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
