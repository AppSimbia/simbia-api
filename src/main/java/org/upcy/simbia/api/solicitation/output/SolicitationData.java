package org.upcy.simbia.api.solicitation.output;

import org.upcy.simbia.api.industry.output.IndustryResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.Post;

public record SolicitationData(Post post, IndustryResponseDto industry, SolicitationResponseDto.SolicitationType solicitationType) {
}
