package org.upcy.simbia.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.LoginRequestDto;
import org.upcy.simbia.dto.response.LoginResponseDto;
import org.upcy.simbia.model.Login;
import org.upcy.simbia.repository.LoginRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    private LoginResponseDto toDto(Login login) {
        LoginResponseDto dto = new LoginResponseDto();
        dto.setUserName(login.getUserName());
        dto.setPwdUUID(login.getPwdUUID());
        return dto;
    }

    public LoginResponseDto createLogin(LoginRequestDto dto) {
        Login login = new Login();
        login.setUserName(dto.getUserName());
        login.setPwdUUID(dto.getPwdUUID());
        login.setIsFirstLogin("1");
        login.setActive("1");
        login.setLastChange(new Date());
        login.setLastLogin(new Date());
        loginRepository.save(login);
        return toDto(login);
    }

    public LoginResponseDto findLoginById(Long id) {
        Login login = loginRepository.findById(id)
                .filter(l -> "1".equals(l.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("Login not found"));
        return toDto(login);
    }

    @Transactional
    public LoginResponseDto updateLogin(Long id, LoginRequestDto dto) {
        Login login = loginRepository.findById(id)
                .filter(l -> "1".equals(l.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("Login not found"));
        login.setUserName(dto.getUserName());
        login.setPwdUUID(dto.getPwdUUID());
        login.setLastChange(new Date());
        loginRepository.save(login);
        return toDto(login);
    }

    public void deleteLogin(Long id) {
        Login login = loginRepository.findById(id)
                .filter(l -> "1".equals(l.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("Login not found"));
        login.setActive("0");
        login.setLastChange(new Date());
        loginRepository.save(login);
    }

    public List<LoginResponseDto> listLogins() {
        return loginRepository.findAll()
                .stream()
                .filter(l -> "1".equals(l.getActive()))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public void updateLastLogin(Long id) {
        loginRepository.findById(id).ifPresent(login -> {
            login.setLastLogin(new Date());
            loginRepository.save(login);
        });
    }
}
