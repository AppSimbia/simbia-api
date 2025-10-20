package org.upcy.simbia.dataprovider.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "benefit")
public class Benefit {
    @Id
    @Column(name = "idbenefit")
    private Long idBenefit;

    @Column(name = "cbenefitname", nullable = false, length = 50)
    private String benefitName;

    @Column(name = "cdescription", nullable = false, length = 200)
    private String description;

    @Column(name = "cactive", nullable = false, length = 1)
    private String active;
}
