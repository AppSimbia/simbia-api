package org.upcy.simbia.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.BenefitRequestDto;
import org.upcy.simbia.dto.response.BenefitResponseDto;
import org.upcy.simbia.model.Benefit;
import org.upcy.simbia.repository.BenefitRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BenefitService {

    private final BenefitRepository benefitRepository;
    private final ObjectMapper objectMapper;

    private Benefit toEntity(BenefitRequestDto dto) {
        return objectMapper.convertValue(dto, Benefit.class);
    }

    private BenefitResponseDto toDto(Benefit entity) {
        return objectMapper.convertValue(entity, BenefitResponseDto.class);
    }

    public List<BenefitResponseDto> listBenefits() {
        return benefitRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public BenefitResponseDto findBenefit(Long id) {
        Benefit benefit = benefitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Benefit not found"));
        return toDto(benefit);
    }

    public BenefitResponseDto insertBenefit(@Valid BenefitRequestDto dto) {
        Benefit entity = toEntity(dto);
        entity.setActive("1");
        benefitRepository.save(entity);
        return toDto(entity);

    }

    public void deleteBenefit(Long id) {
        Benefit benefit = benefitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Benefit not found"));

        benefit.setActive("0");
        benefitRepository.save(benefit);
    }

    @Transactional
    public BenefitResponseDto updateBenefit(Long id, @Valid BenefitRequestDto dto) {
        Benefit benefit = benefitRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Benefit not found"));

        Benefit updated = toEntity(dto);
        updated.setIdBenefit(benefit.getIdBenefit());
        updated.setActive(benefit.getActive());

        benefitRepository.save(updated);
        return toDto(updated);
    }
}
