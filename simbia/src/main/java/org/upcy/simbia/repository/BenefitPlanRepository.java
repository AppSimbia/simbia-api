package org.upcy.simbia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upcy.simbia.model.BenefitPlan;

public interface BenefitPlanRepository extends JpaRepository<BenefitPlan,Long> {
}
