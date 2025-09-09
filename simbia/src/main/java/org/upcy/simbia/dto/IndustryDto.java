package org.upcy.simbia.dto;

import lombok.Data;

@Data
public class IndustryDto {
    private long industryType;
    private long plan;
    private long login;
    private String cnpj;
    private String industryName;
    private String description;
    private String contactMail;
    private String cep;
    private String city;
    private String state;
    private String image;

}
