package org.upcy.simbia.service;

import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.RoleDto;
import org.upcy.simbia.model.Role;
import org.upcy.simbia.repository.RoleRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {
    
    private final RoleRepository repository;
    
    public RoleService(RoleRepository roleRepository) {
        this.repository = roleRepository;
    }


    public RoleDto create(RoleDto dto) {
        Role role = new Role();
        role.setRoleName(dto.getRoleName());
        role.setActive("1");
        Role saved = repository.save(role);
        return toDto(saved);
    }

    public List<RoleDto> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public RoleDto findById(Long id) {
        Optional<Role> role = repository.findById(id);
        return role.map(this::toDto).orElse(null);
    }

    public RoleDto update(Long id, RoleDto dto) {
        Optional<Role> opt = repository.findById(id);
        if (opt.isPresent()) {
            Role role = opt.get();
            role.setRoleName(dto.getRoleName());
            Role updated = repository.save(role);
            return toDto(updated);
        }
        return null;
    }

    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private RoleDto toDto(Role role) {
        RoleDto dto = new RoleDto();
        dto.setRoleName(role.getRoleName());
        return dto;
    }}
