package org.upcy.simbia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upcy.simbia.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
}
