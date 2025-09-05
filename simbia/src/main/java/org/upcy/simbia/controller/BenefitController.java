package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.BenefitContract;
import org.upcy.simbia.dto.BenefitDto;
import org.upcy.simbia.service.BenefitService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BenefitController implements BenefitContract {

    private final BenefitService service;

    @Override
    public ResponseEntity<BenefitDto> create(BenefitDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @Override
    public ResponseEntity<BenefitDto> findById(Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Override
    public ResponseEntity<List<BenefitDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Override
    public ResponseEntity<BenefitDto> update(Long id, BenefitDto dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
