package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.LoginContract;
import org.upcy.simbia.dto.request.LoginRequestDto;
import org.upcy.simbia.dto.response.LoginResponseDto;
import org.upcy.simbia.service.LoginService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoginController implements LoginContract {

    private final LoginService loginService;

    @Override
    public ResponseEntity<LoginResponseDto> createLogin(LoginRequestDto dto) {
        return ResponseEntity.status(201).body(loginService.createLogin(dto));
    }

    @Override
    public ResponseEntity<LoginResponseDto> findLoginById(Long id) {
        return ResponseEntity.ok(loginService.findLoginById(id));
    }

    @Override
    public ResponseEntity<LoginResponseDto> updateLogin(Long id, LoginRequestDto dto) {
        return ResponseEntity.ok(loginService.updateLogin(id, dto));
    }

    @Override
    public ResponseEntity<Void> deleteLogin(Long id) {
        loginService.deleteLogin(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<LoginResponseDto>> listLogins() {
        return ResponseEntity.ok(loginService.listLogins());
    }

    @Override
    public ResponseEntity<Void> updateLastLogin(Long id) {
        loginService.updateLastLogin(id);
        return ResponseEntity.noContent().build();
    }
}
