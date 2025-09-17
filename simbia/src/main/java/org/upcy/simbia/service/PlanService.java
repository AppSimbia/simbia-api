package org.upcy.simbia.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.PlanRequestDto;
import org.upcy.simbia.dto.response.PlanResponseDto;
import org.upcy.simbia.model.Plan;
import org.upcy.simbia.repository.PlanRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlanService {

    private final PlanRepository planRepository;
    private final ObjectMapper objectMapper;

    private Plan toEntity(PlanRequestDto dto) {
        return objectMapper.convertValue(dto, Plan.class);
    }

    private PlanResponseDto toDto(Plan entity) {
        return objectMapper.convertValue(entity, PlanResponseDto.class);
    }

    public List<PlanResponseDto> listPlans() {
        return planRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public PlanResponseDto getPlan(Long id) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan not found"));
        return toDto(plan);
    }

    public PlanResponseDto createPlan(@Valid PlanRequestDto dto) {
        Plan entity = toEntity(dto);
        entity.setActive("1");
        planRepository.save(entity);
        return toDto(entity);
    }

    @Transactional
    public PlanResponseDto updatePlan(Long id, @Valid PlanRequestDto dto) {
        Plan existing = planRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan not found"));

        Plan updated = toEntity(dto);
        updated.setIdPlan(existing.getIdPlan());
        updated.setActive(existing.getActive());

        planRepository.save(updated);
        return toDto(updated);
    }

    public void deletePlan(Long id) {
        Plan plan = planRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan not found"));

        plan.setActive("0");
        planRepository.save(plan);
    }
}
