package org.upcy.simbia.api.solicitation.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SolicitationResponseDto {

    private Long idPost;
    private String cnpjIndustry;
    private String industryName;
    private String industryImage;
    private String image;
    private String title;
    private Integer quantity;
    private String measureUnit;
    private String categoryName;
    private String classification;
    private String description;

}
