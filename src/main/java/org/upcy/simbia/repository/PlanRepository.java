package org.upcy.simbia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upcy.simbia.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
