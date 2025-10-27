package org.upcy.simbia.dataprovider.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.upcy.simbia.dataprovider.persistence.entity.Login;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {

    Optional<Login> findByUserName(String userName);

    @Query(value = "SELECT FN_TableIdGenerator('loginindustry', 'idloginindustry')", nativeQuery = true)
    Long generateId();

    @Procedure(procedureName = "sp_updateuserpassword")
    void updateUserPassword(@Param("acusername") String userName, @Param("acpassword") String newPassword);

    @Query(value = "SELECT fn_validatelogin(:username, :password)", nativeQuery = true)
    Boolean validateUser(@Param("username") String username, @Param("password") String password);

}
