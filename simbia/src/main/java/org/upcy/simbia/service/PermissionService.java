package org.upcy.simbia.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.PermissionRequestDto;
import org.upcy.simbia.dto.response.PermissionResponseDto;
import org.upcy.simbia.model.Permission;
import org.upcy.simbia.repository.PermissionRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;

    private PermissionResponseDto toDto(Permission permission) {
        PermissionResponseDto dto = new PermissionResponseDto();
        dto.setPermissionName(permission.getPermissionName());
        return dto;
    }

    public List<PermissionResponseDto> listPermissions() {
        return permissionRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public PermissionResponseDto findPermissionById(Long id) {
        Permission permission = permissionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Permission not found"));
        return toDto(permission);
    }

    public PermissionResponseDto createPermission(PermissionRequestDto dto) {
        Permission permission = new Permission();
        permission.setPermissionName(dto.getPermissionName());
        permission.setActive("1");
        Permission saved = permissionRepository.save(permission);
        return toDto(saved);
    }

    @Transactional
    public PermissionResponseDto updatePermission(Long id, PermissionRequestDto dto) {
        Permission existing = permissionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Permission not found"));
        existing.setPermissionName(dto.getPermissionName());
        permissionRepository.save(existing);
        return toDto(existing);
    }

    public void deletePermission(Long id) {
        Permission existing = permissionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Permission not found"));
        existing.setActive("0");
        permissionRepository.save(existing);
    }
}
