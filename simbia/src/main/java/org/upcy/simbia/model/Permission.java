package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Permission")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cPermissionName")
    private String permissionName;

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}
