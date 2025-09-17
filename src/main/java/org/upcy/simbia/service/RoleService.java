package org.upcy.simbia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.RoleRequestDto;
import org.upcy.simbia.dto.response.RoleResponseDto;
import org.upcy.simbia.model.Role;
import org.upcy.simbia.repository.RoleRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    private RoleResponseDto toDto(Role role) {
        RoleResponseDto dto = new RoleResponseDto();
        dto.setRoleName(role.getRoleName());
        return dto;
    }

    public List<RoleResponseDto> listRoles() {
        return roleRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public RoleResponseDto findRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        return toDto(role);
    }

    public RoleResponseDto createRole(RoleRequestDto dto) {
        Role role = new Role();
        role.setRoleName(dto.getRoleName());
        role.setActive("1");
        Role saved = roleRepository.save(role);
        return toDto(saved);
    }

    @Transactional
    public RoleResponseDto updateRole(Long id, RoleRequestDto dto) {
        Role existing = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        existing.setRoleName(dto.getRoleName());
        roleRepository.save(existing);
        return toDto(existing);
    }

    public void deleteRole(Long id) {
        Role existing = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found"));
        existing.setActive("0");
        roleRepository.save(existing);
    }
}
