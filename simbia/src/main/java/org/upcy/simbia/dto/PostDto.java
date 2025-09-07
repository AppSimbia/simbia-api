package org.upcy.simbia.dto;

import lombok.Data;

import java.util.Date;

@Data
public class PostDto {
    private Long productCategory;
    private Long industry;
    private Long employee;
    private String title;
    private String description;
    private int quantity;
    private String measureUnit;
    private String image;
    private Date publicationDate;
}
