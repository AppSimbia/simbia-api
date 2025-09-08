package org.upcy.simbia.service;

import org.springframework.stereotype.Service;
import org.upcy.simbia.model.Login;
import org.upcy.simbia.dto.LoginDto;
import org.upcy.simbia.repository.LoginRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Login create(LoginDto dto) {
        Login login = new Login();
        login.setUserName(dto.getUserName());
        login.setPwdUUID(dto.getPwdUUID());
        login.setIsFirstLogin(dto.getIsFirstLogin());
        login.setActive("1");
        login.setLastChange(new Date());
        login.setLastLogin(new Date());
        return loginRepository.save(login);
    }

    public Optional<Login> findById(Long id) {
        return loginRepository.findById(id)
                .filter(login -> "1".equals(login.getActive()));
    }

    public Optional<Login> update(Long id, LoginDto dto) {
        return loginRepository.findById(id).map(existing -> {
            existing.setUserName(dto.getUserName());
            existing.setPwdUUID(dto.getPwdUUID());
            existing.setIsFirstLogin(dto.getIsFirstLogin());
            existing.setLastChange(new Date());
            return loginRepository.save(existing);
        });
    }

    public boolean delete(Long id) {
        return loginRepository.findById(id).map(existing -> {
            existing.setActive("0");
            existing.setLastChange(new Date());
            loginRepository.save(existing);
            return true;
        }).orElse(false);
    }

    public void updateLastLogin(Long id) {
        loginRepository.findById(id).ifPresent(existing -> {
            existing.setLastLogin(new Date());
            if (existing.getIsFirstLogin().equals("1")) {
                existing.setIsFirstLogin("0");
            };
            loginRepository.save(existing);
        });
    }
}
