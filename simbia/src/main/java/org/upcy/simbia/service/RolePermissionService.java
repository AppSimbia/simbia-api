package org.upcy.simbia.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.RolePermissionRequestDto;
import org.upcy.simbia.dto.response.RolePermissionResponseDto;
import org.upcy.simbia.model.Permission;
import org.upcy.simbia.model.Role;
import org.upcy.simbia.model.RolePermission;
import org.upcy.simbia.repository.PermissionRepository;
import org.upcy.simbia.repository.RolePermissionRepository;
import org.upcy.simbia.repository.RoleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolePermissionService {

    private final RolePermissionRepository rolePermissionRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    private RolePermissionResponseDto toDto(RolePermission entity) {
        RolePermissionResponseDto dto = new RolePermissionResponseDto();
        dto.setIdRole(entity.getIdRole().getIdRole());
        dto.setIdPermission(entity.getIdPermission().getIdPermission());
        return dto;
    }

    private Role getRole(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));
    }

    private Permission getPermission(Long id) {
        return permissionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Permission not found"));
    }

    public List<RolePermissionResponseDto> listRolePermissions() {
        return rolePermissionRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public RolePermissionResponseDto findRolePermissionById(Long id) {
        RolePermission entity = rolePermissionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("RolePermission not found"));
        return toDto(entity);
    }

    public RolePermissionResponseDto createRolePermission(RolePermissionRequestDto dto) {
        Role role = getRole(dto.getIdRole());
        Permission permission = getPermission(dto.getIdPermission());

        RolePermission entity = new RolePermission();
        entity.setIdRole(role);
        entity.setIdPermission(permission);
        entity.setActive("1");

        rolePermissionRepository.save(entity);
        return toDto(entity);
    }

    @Transactional
    public void deleteRolePermission(Long id) {
        RolePermission entity = rolePermissionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("RolePermission not found"));
        entity.setActive("0");
        rolePermissionRepository.save(entity);
    }
}
