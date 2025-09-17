package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatch;

    @ManyToOne
    @JoinColumn(name = "idEmployee", nullable = false)
    private Employee idEmployee;

    @ManyToOne
    @JoinColumn(name = "idPost", nullable = false)
    private Post idPost;

    @ManyToOne
    @JoinColumn(name = "idIndustryOrigin", nullable = false)
    private Industry industryOrigin;

    @ManyToOne
    @JoinColumn(name = "idIndustryDestine", nullable = false)
    private Industry industryDestine;

    @Column(name = "cStatus", nullable = false, length = 1)
    private String status; // 1-Created; 2-Negotiating; 3-Accepted; 4-Rejected
}

