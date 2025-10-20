package org.upcy.simbia.dataprovider.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upcy.simbia.dataprovider.persistence.entity.IndustryType;

public interface IndustryTypeRepository extends JpaRepository<IndustryType, Long> {
}
