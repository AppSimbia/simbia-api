package org.upcy.simbia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upcy.simbia.model.Industry;

public interface IndustryRepository extends JpaRepository<Industry, Long> {
}
