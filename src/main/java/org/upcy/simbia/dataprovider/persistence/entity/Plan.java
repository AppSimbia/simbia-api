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
@Table(name = "plan")
public class Plan {
    @Id
    @Column(name = "idplan")
    private Long id;

    @Column(name = "cplanname", nullable = false, length = 50)
    private String planName;

    @Column(name = "nprice", nullable = false)
    private Double price;

    @Column(name = "cactive", nullable = false, length = 1)
    private String active;
}
