package org.upcy.simbia.service;

import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.PlanDto;
import org.upcy.simbia.model.Plan;
import org.upcy.simbia.repository.PlanRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public Plan create(PlanDto dto) {
        if (dto.getPlanName() == null || dto.getPlanName().isBlank()) {
            throw new RuntimeException("Plan name is required");
        }

        Plan plan = new Plan();
        plan.setPlanName(dto.getPlanName());
        plan.setPrice(dto.getPrice());
        plan.setActive("1");
        return planRepository.save(plan);
    }

    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    public Optional<Plan> findById(Long id) {
        return planRepository.findById(id);
    }

    public Plan update(Long id, PlanDto dto) {
        return planRepository.findById(id)
                .map(existing -> {
                    if (dto.getPlanName() == null || dto.getPlanName().isBlank()) {
                        throw new RuntimeException("Plan name is required");
                    }
                    existing.setPlanName(dto.getPlanName());
                    existing.setPrice(dto.getPrice());
                    return planRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Plan not found with id: " + id));
    }

    public void delete(Long id) {
        planRepository.findById(id)
                .map(existing -> {
                    existing.setActive("0");
                    return planRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Plan not found with id: " + id));
    }
}
