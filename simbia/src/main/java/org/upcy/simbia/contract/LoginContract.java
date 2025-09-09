package org.upcy.simbia.contract;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.LoginDto;
import org.upcy.simbia.model.Login;

import jakarta.validation.Valid;
import java.util.Optional;

@RequestMapping("/logins")
public interface LoginContract {

    @Operation(summary = "Cria um novo login")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Login criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping
    ResponseEntity<Login> create(@Valid @RequestBody LoginDto dto);

    @Operation(summary = "Retorna um login pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login encontrado"),
            @ApiResponse(responseCode = "404", description = "Login não encontrado")
    })
    @GetMapping("/{id}")
    ResponseEntity<Optional<Login>> findById(@PathVariable Long id);

    @Operation(summary = "Atualiza um login existente")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login atualizado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
            @ApiResponse(responseCode = "404", description = "Login não encontrado")
    })
    @PutMapping("/{id}")
    ResponseEntity<Optional<Login>> update(@PathVariable Long id, @Valid @RequestBody LoginDto dto);

    @Operation(summary = "Remove um login pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Login deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Login não encontrado")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @Operation(summary = "Atualiza a data do último login do usuário")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Último login atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Login não encontrado")
    })
    @PatchMapping("/{id}/last-login")
    ResponseEntity<Void> updateLastLogin(@PathVariable Long id);
}
