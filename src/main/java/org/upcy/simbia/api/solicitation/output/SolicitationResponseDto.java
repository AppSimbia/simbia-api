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
    private Long idIndustry;
    private String cIndustryName;
    private String cIndustryImage;
    private String cImage;
    private String cTitle;
    private Integer nQuantity;
    private String cMeasureUnit;
    private String cCategoryName;
    private String cClassification;
    private String cDescription;
    private String cActive;

}
