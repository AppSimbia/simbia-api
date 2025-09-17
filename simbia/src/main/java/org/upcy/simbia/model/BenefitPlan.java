package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "BenefitPlan")
public class BenefitPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBenefitPlan;

    @ManyToOne
    @JoinColumn(name = "idBenefit", nullable = false)
    private Benefit idBenefit;

    @ManyToOne
    @JoinColumn(name = "idPlan")
    private Plan idPlan;

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}
