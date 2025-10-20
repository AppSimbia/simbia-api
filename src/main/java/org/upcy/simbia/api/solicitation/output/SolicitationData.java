package org.upcy.simbia.api.solicitation.output;

import org.upcy.simbia.dataprovider.persistence.entity.Industry;
import org.upcy.simbia.dataprovider.persistence.entity.Post;

public record SolicitationData(Post post, Industry industry) {
}
