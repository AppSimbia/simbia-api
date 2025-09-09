package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.PostDto;
import org.upcy.simbia.model.Post;

import jakarta.validation.Valid;
import java.util.List;

@RequestMapping("/posts")
public interface PostContract {

    @Operation(summary = "Cria um novo post")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Post criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<Post> create(@Valid @RequestBody PostDto dto);

    @Operation(summary = "Lista todos os posts")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lista de posts retornada com sucesso")
    })
    @GetMapping
    ResponseEntity<List<Post>> findAll();

    @Operation(summary = "Retorna um post pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Post encontrado"),
            @ApiResponse(responseCode = "404", description = "Post não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<Post> findById(@PathVariable Long id);

    @Operation(summary = "Atualiza um post existente pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Post atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Post não encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<Post> update(@PathVariable Long id, @Valid @RequestBody PostDto dto);

    @Operation(summary = "Remove um post pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Post deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Post não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
