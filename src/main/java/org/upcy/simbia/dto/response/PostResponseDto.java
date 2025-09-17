package org.upcy.simbia.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class PostResponseDto {
    private Long idProductCategory;
    private Long idIndustry;
    private Long idEmployee;
    private String title;
    private String description;
    private int quantity;
    private String measureUnit;
    private String image;
    private Date publicationDate;
}
