package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Login login;

    @Column(name = "cEmployeeName")
    private String employeeName;

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}
