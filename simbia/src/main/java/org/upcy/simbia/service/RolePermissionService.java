package org.upcy.simbia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.RolePermissionDto;
import org.upcy.simbia.model.Role;
import org.upcy.simbia.model.RolePermission;
import org.upcy.simbia.model.Permission;
import org.upcy.simbia.repository.RolePermissionRepository;
import org.upcy.simbia.repository.RoleRepository;
import org.upcy.simbia.repository.PermissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolePermissionService {

    private final RolePermissionRepository rolePermissionRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public RolePermission create(RolePermissionDto dto) {
        Role role = roleRepository.findById(dto.getRole())
                .orElseThrow(() -> new RuntimeException("Role não encontrado"));

        Permission permission = permissionRepository.findById(dto.getPermission())
                .orElseThrow(() -> new RuntimeException("Permission não encontrado"));

        RolePermission rolePermission = new RolePermission();
        rolePermission.setRole(role);
        rolePermission.setPermission(permission);
        rolePermission.setActive("1");

        return rolePermissionRepository.save(rolePermission);
    }

    public List<RolePermission> findAll() {
        return rolePermissionRepository.findAll();
    }

    public RolePermission findById(Long id) {
        return rolePermissionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RolePermission não encontrado"));
    }

    public void delete(Long id) {
        RolePermission bp = findById(id);
        if (!"0".equals(bp.getActive())) {
            bp.setActive("0");
            rolePermissionRepository.save(bp);
        }
    }
}
