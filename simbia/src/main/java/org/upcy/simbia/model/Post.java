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
    private Long id;

    @ManyToOne
    private ProductCategory productCategory;

    @ManyToOne
    private Industry industry;

    @ManyToOne
    private Employee employee;

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

    @Column(name = "cActive", nullable = false, length = 1)
    private String active;
}

