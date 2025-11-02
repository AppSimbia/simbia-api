package org.upcy.simbia.dataprovider.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.upcy.simbia.dataprovider.persistence.entity.Industry;

import java.util.Optional;

public interface IndustryRepository extends JpaRepository<Industry, Long> {

    Optional<Industry> findIndustryByCnpj(String cnpj);

    @Query(value = "SELECT i.* FROM industry as i JOIN employee as e ON e.idindustry = i.idindustry WHERE e.idemployee = :id", nativeQuery = true)
    Optional<Industry> findIndustryByIdEmployee(@Param("id") Long id);

    @Query(value = "SELECT FN_TableIdGenerator('industry', 'idindustry')", nativeQuery = true)
    Long generateId();

}
