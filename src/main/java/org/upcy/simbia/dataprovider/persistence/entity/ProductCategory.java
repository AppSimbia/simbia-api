package org.upcy.simbia.dataprovider.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "productcategory")
public class ProductCategory {
    @Id
    @Column(name = "idproductcategory")
    private Long id;

    @Column(name = "ccategoryname")
    private String categoryName;

    @Column(name = "cinfo")
    private String info;

    @Column(name = "cactive", nullable = false, length = 1)
    private String active;
}
