package org.upcy.simbia.dataprovider.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.upcy.simbia.dataprovider.persistence.entity.Login;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Optional<Login> findByUserName(String userName);

    @Query(value = "SELECT fn_generatehashsenha(:username, :password, :passwordUuid)", nativeQuery = true)
    String generateHashSenha(@Param("username") String username, @Param("password") String password, @Param("passwordUuid") String passUuid);

    @Query(value = "SELECT FN_TableIdGenerator('loginindustry', 'idloginindustry')", nativeQuery = true)
    Long generateId();

}
