package org.upcy.simbia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upcy.simbia.model.Match;

public interface MatchRepository extends JpaRepository<Match,Long> {
}
