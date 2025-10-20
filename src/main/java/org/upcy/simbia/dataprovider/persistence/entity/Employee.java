package org.upcy.simbia.dataprovider.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Query;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @Column(name = "idemployee")
    private Long idEmployee;

    @ManyToOne
    @JoinColumn(name = "idindustry")
    private Industry industry;

    @Column(name = "cemployeename")
    private String employeeName;

    @Column(name = "cactive", nullable = false, length = 1)
    private String active;
}
