package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RolePermission")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRolePermission;

    @ManyToOne
    @JoinColumn(name = "idRole", nullable = false)
    private Role idRole;

    @ManyToOne
    @JoinColumn(name = "idPermission", nullable = false)
    private Permission idPermission;

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}
