package org.upcy.simbia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.IndustryContract;
import org.upcy.simbia.dto.IndustryDto;
import org.upcy.simbia.model.Industry;
import org.upcy.simbia.service.IndustryService;

import java.util.Optional;

@RestController
public class IndustryController implements IndustryContract {

    private final IndustryService industryService;

    public IndustryController(IndustryService industryService) {
        this.industryService = industryService;
    }

    @Override
    public ResponseEntity<Industry> create(IndustryDto dto) {
        return ResponseEntity.ok(industryService.create(dto));
    }

    @Override
    public ResponseEntity<Optional<Industry>> findById(Long id) {
        return ResponseEntity.ok(industryService.findById(id));
    }

    @Override
    public ResponseEntity<Optional<Industry>> update(Long id, IndustryDto dto) {
        return ResponseEntity.ok(industryService.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        boolean deleted = industryService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
