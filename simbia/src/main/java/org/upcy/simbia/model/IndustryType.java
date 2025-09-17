package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "IndustryType")
public class IndustryType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIndustryType;

    @Column(name = "cIndustryTypeName")
    private String industryTypeName;

    @Column(name = "cInfo")
    private String info;

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}
