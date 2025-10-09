package org.upcy.simbia.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.upcy.simbia.validation.OnCreate;

@Data
public class IndustryRequestDto {
    @Schema(example = "1", description = "ID of the industry type")
    @NotNull(groups = OnCreate.class)
    private Long idIndustryType;

    @Schema(example = "2", description = "ID of the associated plan")
    @NotNull(groups = OnCreate.class)
    private Long idPlan;

    @Schema(example = "3", description = "ID of the associated login")
    @NotNull(groups = OnCreate.class)
    private Long idLoginIndustry;

    @Schema(example = "12.345.678/0001-90", description = "Industry CNPJ")
    @NotNull(groups = OnCreate.class)
    @Pattern(regexp = "\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}", message = "Invalid CNPJ")
    private String cnpj;

    @Schema(example = "Industry example", description = "Industry name")
    @NotNull(groups = OnCreate.class)
    @Pattern(regexp = ".*\\S.*\\S.*", message = "Name must be at least 2 characters long")
    private String industryName;

    @Schema(example = "Example description", description = "Industry description")
    @NotNull(groups = OnCreate.class)
    @Pattern(regexp = ".*\\S.*\\S.*", message = "Description must be at least 2 characters long")
    private String description;

    @Schema(example = "contact@company.com", description = "Contact email")
    @NotNull(groups = OnCreate.class)
    @Email(message = "Invalid email")
    private String contactMail;

    @Schema(example = "12345-678", description = "Industry ZIP code")
    @NotNull(groups = OnCreate.class)
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "Invalid ZIP code")
    private String cep;

    @Schema(example = "New York", description = "City of the industry")
    @NotNull(groups = OnCreate.class)
    @Size(min = 2, message = "City must be at least 2 characters long")
    private String city;

    @Schema(example = "NY", description = "State of the industry")
    @NotNull(groups = OnCreate.class)
    @Size(min = 2, max = 2, message = "State must have 2 characters")
    private String state;

    @Schema(example = "https://example.com/image.png", description = "Image URL")
    private String image;
}
