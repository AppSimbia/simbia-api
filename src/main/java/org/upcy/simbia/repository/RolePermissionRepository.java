package org.upcy.simbia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.upcy.simbia.model.RolePermission;

public interface RolePermissionRepository extends JpaRepository<RolePermission, Long> {
}
