package org.upcy.simbia.dataprovider.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.upcy.simbia.dataprovider.persistence.entity.Benefit;

import java.util.List;

public interface BenefitRepository extends JpaRepository<Benefit,Long> {

    @Query(value = "SELECT b.idbenefit, b.cbenefitname, b.cdescription, b.cactive FROM benefit b " +
            "JOIN benefitplan bp ON b.idbenefit = bp.idbenefit " +
            "JOIN plan p ON bp.idplan = p.idplan " +
            "WHERE p.idplan = :idPlan AND bp.cactive = '1'", nativeQuery = true)
    List<Benefit> findAllBenefitsByIdPlan(@Param("idPlan") Long idPlan);

}
