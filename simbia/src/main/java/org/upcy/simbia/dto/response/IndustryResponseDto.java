package org.upcy.simbia.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class IndustryResponseDto {
    @Schema(example = "1", description = "ID of the industry type")
    private Long idIndustryType;

    @Schema(example = "2", description = "ID of the associated plan")
    private Long idPlan;

    @Schema(example = "3", description = "ID of the associated login")
    private Long idLoginIndustry;

    @Schema(example = "12.345.678/0001-90", description = "Industry CNPJ")
    private String cnpj;

    @Schema(example = "Industry example", description = "Industry name")
    private String industryName;

    @Schema(example = "Example description", description = "Industry description")
    private String description;

    @Schema(example = "contact@company.com", description = "Contact email")
    private String contactMail;

    @Schema(example = "12345-678", description = "Industry ZIP code")
    private String cep;

    @Schema(example = "New York", description = "City of the industry")
    private String city;

    @Schema(example = "NY", description = "State of the industry")
    private String state;

    @Schema(example = "https://example.com/image.png", description = "Image URL")
    private String image;
}
