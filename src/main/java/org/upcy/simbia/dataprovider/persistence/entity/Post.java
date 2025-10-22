package org.upcy.simbia.dataprovider.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "idpost")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idproductcategory", nullable = false)
    private ProductCategory idProductCategory;

    @ManyToOne
    @JoinColumn(name = "idindustry", nullable = false)
    private Industry idIndustry;

    @ManyToOne
    @JoinColumn(name = "idemployee", nullable = false)
    private Employee idEmployee;

    @Column(name = "ctitle")
    private String title;

    @Column(name = "cdescription")
    private String description;

    @Column(name = "nquantity")
    private int quantity;

    @Column(name = "cmeasureunit")
    private String measureUnit;

    @Column(name = "cclassification")
    private String classification;

    @Column(name = "cimage")
    private String image;

    @Column(name = "dpublication")
    private Date publicationDate;

    @Column(name = "cactive", nullable = false, length = 1)
    private String active;
}

