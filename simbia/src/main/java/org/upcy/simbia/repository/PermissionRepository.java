package org.upcy.simbia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upcy.simbia.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
