package org.upcy.simbia.api.industry.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CNPJ;
import org.upcy.simbia.validation.OnCreate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginIndustryDto {

    @Schema(example = "12345678000190", description = "Industry CNPJ")
    @NotNull(groups = OnCreate.class)
    @CNPJ(message = "Invalid CNPJ")
    private String cnpj;

    @Schema(example = "teste", description = "Password UUID")
    @NotNull(message = "Password UUID must not be null", groups = OnCreate.class)
    @Pattern(regexp = ".*\\S.*\\S.*", message = "Password UUID must be at least 2 non-blank characters")
    private String password;

}
