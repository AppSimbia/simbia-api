package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RoleEmployee")
public class RoleEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idEmployee", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "idRole", nullable = false)
    private Role role;
}
