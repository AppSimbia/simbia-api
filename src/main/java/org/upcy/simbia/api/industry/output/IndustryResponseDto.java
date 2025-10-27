package org.upcy.simbia.api.industry.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.upcy.simbia.dataprovider.persistence.entity.IndustryType;
import org.upcy.simbia.dataprovider.persistence.entity.Plan;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IndustryResponseDto {
    private Long idIndustry;
    private IndustryType industryType;
    private Plan plan;
    private LoginResponseDto login;
    private String cnpj;
    private String industryName;
    private String description;
    private String contactMail;
    private String cep;
    private String city;
    private Double latitude;
    private Double longitude;
    private String state;
    private String image;
}
