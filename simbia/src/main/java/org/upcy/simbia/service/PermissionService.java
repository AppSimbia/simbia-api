package org.upcy.simbia.service;

import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.PermissionDto;
import org.upcy.simbia.model.Permission;
import org.upcy.simbia.repository.PermissionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PermissionService {

    private final PermissionRepository repository;

    public PermissionService(PermissionRepository repository) {
        this.repository = repository;
    }

    public PermissionDto create(PermissionDto dto) {
        Permission permission = new Permission();
        permission.setPermissionName(dto.getPermissionName());
        permission.setActive("1");
        Permission saved = repository.save(permission);
        return toDto(saved);
    }

    public List<PermissionDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public PermissionDto findById(Long id) {
        Optional<Permission> permission = repository.findById(id);
        return permission.map(this::toDto).orElse(null);
    }

    public PermissionDto update(Long id, PermissionDto dto) {
        Optional<Permission> opt = repository.findById(id);
        if (opt.isPresent()) {
            Permission permission = opt.get();
            permission.setPermissionName(dto.getPermissionName());
            Permission updated = repository.save(permission);
            return toDto(updated);
        }
        return null;
    }

    public void delete(Long id) {
        repository.findById(id)
                .map(existing -> {
                    existing.setActive("0");
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Permission not found with id " + id));
    }

    private PermissionDto toDto(Permission permission) {
        PermissionDto dto = new PermissionDto();
        dto.setPermissionName(permission.getPermissionName());
        return dto;
    }
}
