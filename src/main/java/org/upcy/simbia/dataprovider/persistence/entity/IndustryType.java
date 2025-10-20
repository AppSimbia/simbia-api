package org.upcy.simbia.dataprovider.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "industrytype")
public class IndustryType {
    @Id
    @Column(name = "idindustrytype")
    private Long id;

    @Column(name = "cindustrytypename")
    private String industryTypeName;

    @Column(name = "cinfo")
    private String info;

    @Column(name = "cactive", nullable = false, length = 1)
    private String active;
}
