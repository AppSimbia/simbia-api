package org.upcy.simbia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upcy.simbia.model.Benefit;

public interface BenefitRepository extends JpaRepository<Benefit,Long> {
}
