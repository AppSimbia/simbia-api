package org.upcy.simbia.api.industry;

import com.fasterxml.jackson.databind.JsonMappingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.api.industry.input.IndustryRequestDto;
import org.upcy.simbia.api.industry.input.LoginIndustryDto;
import org.upcy.simbia.api.industry.output.IndustryResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.IndustryType;

import java.util.List;
import java.util.Map;

@Validated
@RequestMapping("/industries")
public interface IndustryContract {

    @Operation(summary = "Create a new industry")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Industry successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping
    ResponseEntity<IndustryResponseDto> save(@Valid @RequestBody IndustryRequestDto dto);

    @Operation(summary = "Login industry")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Industry successfully login"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    @PostMapping("/login")
    ResponseEntity<IndustryResponseDto> loginIndustry(@Valid @RequestBody LoginIndustryDto request);

    @Operation(summary = "Get a specific industry by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Industry found"),
            @ApiResponse(responseCode = "404", description = "Industry not found")
    })
    @GetMapping("/id/{id}")
    ResponseEntity<IndustryResponseDto> findIndustryById(@PathVariable Long id);

    @Operation(summary = "Get a specific industry by ID employee")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Industry found"),
            @ApiResponse(responseCode = "404", description = "Industry not found")
    })
    @GetMapping("/id/{id}/employee")
    ResponseEntity<IndustryResponseDto> findIndustryByIdEmployee(@PathVariable Long id);

    @Operation(summary = "Get a specific industry by CNPJ")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Industry found"),
            @ApiResponse(responseCode = "404", description = "Industry not found")
    })
    @GetMapping("/cnpj/{cnpj}")
    ResponseEntity<IndustryResponseDto> findIndustryByCnpj(@CNPJ @PathVariable String cnpj);

    @Operation(summary = "Get all industries types")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Industry found"),
            @ApiResponse(responseCode = "404", description = "Industry not found")
    })
    @GetMapping("/types")
    ResponseEntity<List<IndustryType>> findAllIndustriesTypes();

    @Operation(summary = "Update an existing industry")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Industry successfully updated"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided"),
            @ApiResponse(responseCode = "404", description = "Industry not found")
    })
    @PutMapping("/{cnpj}")
    ResponseEntity<IndustryResponseDto> updateIndustry(@CNPJ @PathVariable String cnpj,
                                                                 @RequestBody Map<String, Object> dto) throws JsonMappingException;
}
