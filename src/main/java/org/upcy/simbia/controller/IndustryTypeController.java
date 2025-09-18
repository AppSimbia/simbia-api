package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.IndustryTypeContract;
import org.upcy.simbia.dto.request.IndustryTypeRequestDto;
import org.upcy.simbia.dto.response.IndustryTypeResponseDto;
import org.upcy.simbia.service.IndustryTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IndustryTypeController implements IndustryTypeContract {

    private final IndustryTypeService service;

    @Override
    public ResponseEntity<IndustryTypeResponseDto> createIndustryType(IndustryTypeRequestDto dto) {
        return ResponseEntity.status(201).body(service.createIndustryType(dto));
    }

    @Override
    public ResponseEntity<IndustryTypeResponseDto> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<List<IndustryTypeResponseDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<IndustryTypeResponseDto> updateIndustryType(Long id, IndustryTypeRequestDto dto) {
        return ResponseEntity.ok(service.updateIndustryType(id, dto));
    }

    @Override
    public ResponseEntity<Void> deleteIndustryType(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
