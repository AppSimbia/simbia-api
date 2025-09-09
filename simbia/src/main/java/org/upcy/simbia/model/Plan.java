package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPlan")
    private Long idPlan;

    @Column(name = "cPlanName", nullable = false, length = 50)
    private String planName;

    @Column(name = "nPrice", nullable = false)
    private double price;

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}
