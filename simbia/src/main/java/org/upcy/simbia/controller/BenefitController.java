package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.BenefitContract;
import org.upcy.simbia.dto.request.BenefitRequestDto;
import org.upcy.simbia.dto.response.BenefitResponseDto;
import org.upcy.simbia.service.BenefitService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BenefitController implements BenefitContract {

    private final BenefitService service;

    @Override
    public ResponseEntity<BenefitResponseDto> create(BenefitRequestDto dto) {
        return ResponseEntity.ok(service.insertBenefit(dto));
    }

    @Override
    public ResponseEntity<BenefitResponseDto> findById(Long id) {
        return ResponseEntity.ok(service.findBenefit(id));
    }

    @Override
    public ResponseEntity<List<BenefitResponseDto>> findAll() {
        return ResponseEntity.ok(service.listBenefits());
    }

    @Override
    public ResponseEntity<BenefitResponseDto> update(Long id, BenefitRequestDto dto) {
        return ResponseEntity.ok(service.updateBenefit(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        service.deleteBenefit(id);
        return ResponseEntity.noContent().build();
    }
}
