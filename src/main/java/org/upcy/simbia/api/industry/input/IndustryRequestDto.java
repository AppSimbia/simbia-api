package org.upcy.simbia.api.industry.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.upcy.simbia.validation.OnCreate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IndustryRequestDto {

    @Schema(example = "1", description = "ID of the industry type")
    @NotNull(groups = OnCreate.class)
    private Long idIndustryType;

    @Schema(example = "1", description = "ID of the associated plan")
    @NotNull(groups = OnCreate.class)
    private Long idPlan;

    @Schema(example = "1", description = "ID of the associated login")
    private Long idLogin;

    @Schema(example = "12345678000190", description = "Industry CNPJ")
    @NotNull(groups = OnCreate.class)
    @CNPJ(message = "Invalid CNPJ")
    private String cnpj;

    @Schema(example = "a1b2c3d4-5678-90ab-cdef-1234567890ab", description = "Password UUID")
    @NotNull(message = "Password UUID must not be null", groups = OnCreate.class)
    @Pattern(regexp = ".*\\S.*\\S.*", message = "Password UUID must be at least 2 non-blank characters")
    private String password;

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
