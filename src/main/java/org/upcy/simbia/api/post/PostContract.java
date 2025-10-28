package org.upcy.simbia.api.post;

import com.fasterxml.jackson.databind.JsonMappingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.api.post.input.PostRequestDto;
import org.upcy.simbia.api.post.output.PostResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.ProductCategory;

import java.util.List;
import java.util.Map;

@RequestMapping("/posts")
public interface PostContract {

    @Operation(summary = "Create a new post")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Post successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<PostResponseDto> create(@Valid @RequestBody PostRequestDto dto);

    @Operation(summary = "List all posts by industry CNPJ")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of posts successfully returned")
    })
    @GetMapping("/list/{cnpj}")
    ResponseEntity<List<PostResponseDto>> findAllByIndustry(@CNPJ @PathVariable("cnpj") String cnpj);

    @Operation(summary = "List all posts except the industry posts")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of posts successfully returned")
    })
    @GetMapping("/list/{cnpj}/except")
    ResponseEntity<List<PostResponseDto>> findAllExceptIndustry(@CNPJ @PathVariable("cnpj") String cnpj);

    @Operation(summary = "List all products category")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of posts successfully returned")
    })
    @GetMapping("/category/list")
    ResponseEntity<List<ProductCategory>> findAllProductCategory();

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
    ResponseEntity<PostResponseDto> update(@PathVariable Long id, @RequestBody Map<String, Object> map) throws JsonMappingException;

    @Operation(summary = "Delete a post by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Post successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Post not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
