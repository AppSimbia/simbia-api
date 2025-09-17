package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RoleEmployee")
public class RoleEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRoleEmployee;

    @ManyToOne
    @JoinColumn(name = "idEmployee", nullable = false)
    private Employee idEmployee;

    @ManyToOne
    @JoinColumn(name = "idRole", nullable = false)
    private Role idRole;
}
