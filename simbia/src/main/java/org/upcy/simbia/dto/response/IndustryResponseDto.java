package org.upcy.simbia.dto.response;

import lombok.Data;

@Data
public class IndustryResponseDto {
    private long idIndustryType;
    private long idPlan;
    private long idLogin;
    private String cnpj;
    private String industryName;
    private String description;
    private String contactMail;
    private String cep;
    private String city;
    private String state;
    private String image;
}
