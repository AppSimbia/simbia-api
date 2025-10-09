package org.upcy.simbia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;

    @ManyToOne
    @JoinColumn(name = "idProductCategory", nullable = false)
    private ProductCategory idProductCategory;

    @ManyToOne
    @JoinColumn(name = "idIndustry", nullable = false)
    private Industry idIndustry;

    @ManyToOne
    @JoinColumn(name = "idEmployee", nullable = false)
    private Employee idEmployee;

    @Column(name = "cTitle")
    private String title;

    @Column(name = "cDescription")
    private String description;

    @Column(name = "nQuantity")
    private int quantity;

    @Column(name = "cMeasureUnit")
    private String measureUnit;

    @Column(name = "cImage")
    private String image;

    @Column(name = "dPublication")
    private Date publicationDate;

    @Column(name = "cStatus", nullable = false, length = 1)
    private String status;

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}

