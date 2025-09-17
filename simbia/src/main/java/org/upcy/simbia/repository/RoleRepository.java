package org.upcy.simbia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upcy.simbia.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
