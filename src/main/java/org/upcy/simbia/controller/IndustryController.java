package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.IndustryContract;
import org.upcy.simbia.dto.request.IndustryRequestDto;
import org.upcy.simbia.dto.response.IndustryResponseDto;
import org.upcy.simbia.service.IndustryService;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class IndustryController implements IndustryContract {

    private final IndustryService industryService;

    @Override
    public ResponseEntity<IndustryResponseDto> createIndustry(IndustryRequestDto dto) {
        return ResponseEntity.status(201).body(industryService.createIndustry(dto));
    }

    @Override
    public ResponseEntity<Optional<IndustryResponseDto>> findIndustryById(Long id) {
        return ResponseEntity.ok(industryService.findIndustryById(id));
    }

    @Override
    public ResponseEntity<Optional<IndustryResponseDto>> updateIndustry(Long id, IndustryRequestDto dto) {
        return ResponseEntity.ok(industryService.updateIndustry(id, dto));
    }

    @Override
    public ResponseEntity<Void> deleteIndustry(Long id) {
        boolean deleted = industryService.deleteIndustry(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
