package org.upcy.simbia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.LoginContract;
import org.upcy.simbia.dto.LoginDto;
import org.upcy.simbia.model.Login;
import org.upcy.simbia.service.LoginService;

import java.util.Optional;

@RestController
public class LoginController implements LoginContract {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public ResponseEntity<Login> create(LoginDto dto) {
        return ResponseEntity.ok(loginService.create(dto));
    }

    @Override
    public ResponseEntity<Optional<Login>> findById(Long id) {
        return ResponseEntity.ok(loginService.findById(id));
    }

    @Override
    public ResponseEntity<Optional<Login>> update(Long id, LoginDto dto) {
        return ResponseEntity.ok(loginService.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        boolean deleted = loginService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Void> updateLastLogin(Long id) {
        loginService.updateLastLogin(id);
        return ResponseEntity.noContent().build();
    }
}
