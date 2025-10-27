package org.upcy.simbia.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dataprovider.persistence.entity.Login;
import org.upcy.simbia.dataprovider.persistence.repository.LoginRepository;
import org.upcy.simbia.exception.LoginAlreadyExistsException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;

    @Transactional
    public Login createLogin(String userName, String password) {
        if (validateExistsLogin(userName, password)) {
            throw new LoginAlreadyExistsException(userName);
        }
        Login login = Login.builder()
                .id(loginRepository.generateId())
                .userName(userName)
                .isFirstLogin("1")
                .lastChange(LocalDateTime.now().minusDays(1L))
                .active("1")
                .build();
        return loginRepository.save(login);
    }

    @Transactional
    public void updatePassword(String username, String newPassword) {
        loginRepository.updateUserPassword(username, newPassword);
    }

    public Boolean validateExistsLogin(String userName, String password) {
        return loginRepository.validateUser(userName, password);
    }

}
