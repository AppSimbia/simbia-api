package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ProductCategory")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProductCategory;

    @Column(name = "cCategoryName")
    private String categoryName;

    @Column(name = "cInfo")
    private String info;

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}
