package org.upcy.simbia.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.IndustryTypeRequestDto;
import org.upcy.simbia.dto.response.IndustryTypeResponseDto;
import org.upcy.simbia.model.IndustryType;
import org.upcy.simbia.repository.IndustryTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndustryTypeService {

    private final IndustryTypeRepository repository;
    private final ObjectMapper objectMapper;

    private IndustryTypeResponseDto toDto(IndustryType entity) {
        return objectMapper.convertValue(entity, IndustryTypeResponseDto.class);
    }

    public IndustryTypeResponseDto createIndustryType(@Valid IndustryTypeRequestDto dto) {
        if (dto.getIndustryName() == null || dto.getIndustryName().trim().isEmpty()) {
            throw new RuntimeException("Industry name must not be null or empty");
        }

        IndustryType entity = new IndustryType();
        entity.setIndustryTypeName(dto.getIndustryName());
        entity.setInfo(dto.getInfo() != null ? dto.getInfo() : "");
        entity.setActive("1");

        IndustryType saved = repository.save(entity);
        return toDto(saved);
    }

    public IndustryTypeResponseDto findById(Long id) {
        IndustryType entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Industry type not found"));
        return toDto(entity);
    }

    public List<IndustryTypeResponseDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public IndustryTypeResponseDto updateIndustryType(Long id, @Valid IndustryTypeRequestDto dto) {
        IndustryType entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Industry type not found"));
        entity.setIndustryTypeName(dto.getIndustryName());
        entity.setInfo(dto.getInfo());
        return toDto(repository.save(entity));
    }

    public void deleteIndustryType(Long id) {
        IndustryType entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Industry type not found"));
        entity.setActive("0");
        repository.save(entity);
    }
}
