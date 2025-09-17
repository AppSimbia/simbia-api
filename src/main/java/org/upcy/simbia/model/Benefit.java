package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Benefit")
public class Benefit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBenefit")
    private Long idBenefit;

    @Column(name = "cBenefitName", nullable = false, length = 50)
    private String benefitName;

    @Column(name = "cDescription", nullable = false, length = 200)
    private String description;

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}
