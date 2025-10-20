package org.upcy.simbia.dataprovider.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "benefitplan")
public class BenefitPlan {
    @Id
    @Column(name = "idbenefitplan")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idbenefit", nullable = false)
    private Benefit idBenefit;

    @ManyToOne
    @JoinColumn(name = "idplan")
    private Plan idPlan;

    @Column(name = "cactive", nullable = false, length = 1)
    private String active;
}
