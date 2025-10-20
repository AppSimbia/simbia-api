package org.upcy.simbia.dataprovider.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upcy.simbia.dataprovider.persistence.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
