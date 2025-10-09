package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;

    @ManyToOne
    @JoinColumn(name = "idIndustry")
    private Industry idIndustry;

    @Column(name = "cRoleName")
    private String roleName;

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}
