package org.upcy.simbia.service;

import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.IndustryTypeDto;
import org.upcy.simbia.model.IndustryType;
import org.upcy.simbia.repository.IndustryTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndustryTypeService {

    private final IndustryTypeRepository repository;

    public IndustryTypeService(IndustryTypeRepository repository) {
        this.repository = repository;
    }

    public IndustryTypeDto create(IndustryTypeDto dto) {
        if (dto.getIndustryTypeName() == null || dto.getIndustryTypeName().trim().isEmpty()) {
            throw new RuntimeException("O nome do tipo de empresa não pode ser nulo ou vazio");
        }

        IndustryType entity = new IndustryType();
        entity.setIndustryTypeName(dto.getIndustryTypeName());
        entity.setInfo(dto.getInfo() != null ? dto.getInfo() : "");
        entity.setActive("1");

        IndustryType saved = repository.save(entity);
        return toDto(saved);
    }

    public IndustryTypeDto findById(Long id) {
        return repository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new RuntimeException("IndustryType não encontrado"));
    }

    public List<IndustryTypeDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public IndustryTypeDto update(Long id, IndustryTypeDto dto) {
        IndustryType entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("IndustryType não encontrado"));
        entity.setIndustryTypeName(dto.getIndustryTypeName());
        entity.setInfo(dto.getInfo());
        return toDto(repository.save(entity));
    }

    public boolean delete(Long id) {
        return repository.findById(id).map(existing -> {
            existing.setActive("0");
            repository.save(existing);
            return true;
        }).orElse(false);
    }

    private IndustryTypeDto toDto(IndustryType entity) {
        IndustryTypeDto dto = new IndustryTypeDto();
        dto.setIndustryTypeName(entity.getIndustryTypeName());
        dto.setInfo(entity.getInfo());
        return dto;
    }
}
