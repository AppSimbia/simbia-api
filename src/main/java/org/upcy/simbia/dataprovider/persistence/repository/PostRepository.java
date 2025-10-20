package org.upcy.simbia.dataprovider.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.upcy.simbia.dataprovider.persistence.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT FN_TableIdGenerator('post', 'idpost')", nativeQuery = true)
    Long generateId();
}
