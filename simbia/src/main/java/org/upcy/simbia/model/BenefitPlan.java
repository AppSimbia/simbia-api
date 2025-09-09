package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "BenefitPlan")
public class BenefitPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idBenefit", nullable = false)
    private Benefit benefit;

    @ManyToOne
    @JoinColumn(name = "Plan")
    private Plan plan;

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}
