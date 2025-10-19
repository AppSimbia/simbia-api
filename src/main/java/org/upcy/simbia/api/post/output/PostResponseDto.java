package org.upcy.simbia.api.post.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.upcy.simbia.api.employee.output.EmployeeResponseDto;
import org.upcy.simbia.api.industry.output.IndustryResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.ProductCategory;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponseDto {
    private ProductCategory productCategory;
    private String industryName;
    private String industryImage;
    private String industryCnpj;
    private String employeeName;
    private String title;
    private String description;
    private Integer quantity;
    private String measureUnit;
    private String classification;
    private String status;
    private String image;
    private Date publicationDate;
}