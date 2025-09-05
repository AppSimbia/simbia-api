package org.upcy.simbia.service;

import org.upcy.simbia.dto.BenefitDto;
import org.upcy.simbia.model.Benefit;
import org.upcy.simbia.repository.BenefitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BenefitService {

    private final BenefitRepository repository;

    public BenefitDto create(BenefitDto dto) {
        if (dto.getBenefitName() == null || dto.getBenefitName().trim().isEmpty()) {
            throw new RuntimeException("O nome do benefício não pode ser nulo ou vazio");
        }

        Benefit entity = new Benefit();
        entity.setBenefitName(dto.getBenefitName());
        entity.setDescription(dto.getDescription() != null ? dto.getDescription() : "");
        entity.setActive("1");

        Benefit saved = repository.save(entity);
        return toDto(saved);
    }

    public BenefitDto findById(Long id) {
        return repository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("Benefit não encontrado"));
    }

    public List<BenefitDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public BenefitDto update(Long id, BenefitDto dto) {
        Benefit entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Benefit não encontrado"));
        entity.setBenefitName(dto.getBenefitName());
        entity.setDescription(dto.getDescription());
        return toDto(repository.save(entity));
    }

    public void delete(Long id) {
        repository.findById(id)
                .map(existing -> {
                    existing.setActive("0");
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Benefit not found with id " + id));
    }

    private BenefitDto toDto(Benefit entity) {
        BenefitDto dto = new BenefitDto();
        dto.setBenefitName(entity.getBenefitName());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}
