package org.upcy.simbia.dataprovider.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.upcy.simbia.dataprovider.persistence.entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT FN_TableIdGenerator('post', 'idpost')", nativeQuery = true)
    Long generateId();

    @Query(value = "SELECT * FROM post p " +
            "JOIN industry i ON p.idindustry = i.idindustry " +
            "WHERE i.ccnpj = :cnpj AND p.cstatus = :status", nativeQuery = true)
    List<Post> findAllByIndustry(@Param("cnpj") String cnpj, @Param("status") String status);

    @Override
    @Query(value = "SELECT * FROM post p " +
            "WHERE p.cactive = '1'", nativeQuery = true)
    List<Post> findAll();
}
