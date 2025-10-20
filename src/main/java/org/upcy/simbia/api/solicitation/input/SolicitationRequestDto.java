package org.upcy.simbia.api.solicitation.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SolicitationRequestDto {

    private Long idPost;
    private Long idIndustry;

}
