package org.upcy.simbia.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.LoginIndustryRequestDto;
import org.upcy.simbia.dto.response.LoginIndustryResponseDto;
import org.upcy.simbia.model.LoginIndustry;
import org.upcy.simbia.repository.LoginIndustryRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoginIndustryService {

    private final LoginIndustryRepository loginRepository;

    private LoginIndustryResponseDto toDto(LoginIndustry loginIndustry) {
        LoginIndustryResponseDto dto = new LoginIndustryResponseDto();
        dto.setUserName(loginIndustry.getUserName());
        dto.setPwdUUID(loginIndustry.getPwdUUID());
        return dto;
    }

    public LoginIndustryResponseDto createLogin(LoginIndustryRequestDto dto) {
        LoginIndustry loginIndustry = new LoginIndustry();
        loginIndustry.setUserName(dto.getUserName());
        loginIndustry.setPwdUUID(dto.getPwdUUID());
        loginIndustry.setIsFirstLogin("1");
        loginIndustry.setActive("1");
        loginIndustry.setLastChange(new Date());
        loginRepository.save(loginIndustry);
        return toDto(loginIndustry);
    }

    public LoginIndustryResponseDto findLoginById(Long id) {
        LoginIndustry loginIndustry = loginRepository.findById(id)
                .filter(l -> "1".equals(l.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("LoginIndustry not found"));
        return toDto(loginIndustry);
    }

    @Transactional
    public LoginIndustryResponseDto updateLogin(Long id, LoginIndustryRequestDto dto) {
        LoginIndustry loginIndustry = loginRepository.findById(id)
                .filter(l -> "1".equals(l.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("LoginIndustry not found"));
        loginIndustry.setUserName(dto.getUserName());
        loginIndustry.setPwdUUID(dto.getPwdUUID());
        loginIndustry.setLastChange(new Date());
        loginRepository.save(loginIndustry);
        return toDto(loginIndustry);
    }

    public void deleteLogin(Long id) {
        LoginIndustry loginIndustry = loginRepository.findById(id)
                .filter(l -> "1".equals(l.getActive()))
                .orElseThrow(() -> new EntityNotFoundException("LoginIndustry not found"));
        loginIndustry.setActive("0");
        loginIndustry.setLastChange(new Date());
        loginRepository.save(loginIndustry);
    }

    public List<LoginIndustryResponseDto> listLogins() {
        return loginRepository.findAll()
                .stream()
                .filter(l -> "1".equals(l.getActive()))
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public void updateLastLogin(Long id) {
        loginRepository.findById(id).ifPresent(login -> {
            loginRepository.save(login);
        });
    }
}
