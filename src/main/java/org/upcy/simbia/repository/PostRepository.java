package org.upcy.simbia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upcy.simbia.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
