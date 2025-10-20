package org.upcy.simbia.dataprovider.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.upcy.simbia.dataprovider.persistence.entity.Industry;

import java.util.Optional;

public interface IndustryRepository extends JpaRepository<Industry, Long> {

    Optional<Industry> findIndustryByCnpj(String cnpj);

    @Query(value = "SELECT FN_TableIdGenerator('industry', 'idindustry')", nativeQuery = true)
    Long generateId();

}
