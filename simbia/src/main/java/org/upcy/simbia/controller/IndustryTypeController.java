package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.IndustryTypeContract;
import org.upcy.simbia.dto.IndustryTypeDto;
import org.upcy.simbia.service.IndustryTypeService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class IndustryTypeController implements IndustryTypeContract {

    private final IndustryTypeService service;

    @Override
    public ResponseEntity<IndustryTypeDto> create(IndustryTypeDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @Override
    public ResponseEntity<IndustryTypeDto> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<List<IndustryTypeDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<IndustryTypeDto> update(Long id, IndustryTypeDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
