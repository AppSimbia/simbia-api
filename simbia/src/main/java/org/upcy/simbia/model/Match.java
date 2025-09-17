package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idEmployee", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "idPost", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "idIndustryOrigin", nullable = false)
    private Industry industryOrigin;

    @ManyToOne
    @JoinColumn(name = "idIndustryDestine", nullable = false)
    private Industry industryDestine;

    @Column(name = "cStatus", nullable = false, length = 1)
    private String status; // 1-Created; 2-Negotiating; 3-Accepted; 4-Rejected
}

