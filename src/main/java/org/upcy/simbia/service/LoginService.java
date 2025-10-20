package org.upcy.simbia.service;

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

    public Login createLogin(String userName, String password) {
        if (validateExistsLogin(userName)) {
            throw new LoginAlreadyExistsException(userName);
        }
        final String pwdUUID = java.util.UUID.randomUUID().toString();
        final String pwdHash = loginRepository.generateHashSenha(userName, password, pwdUUID);
        Login login = Login.builder()
                .id(loginRepository.generateId())
                .userName(userName)
                .pwdUUID(pwdUUID)
                .pwdHash(pwdHash)
                .isFirstLogin("1")
                .lastChange(LocalDateTime.now().minusDays(1L))
                .active("1")
                .build();
        return loginRepository.save(login);
    }

    public Boolean validateExistsLogin(String userName) {
        return loginRepository.findByUserName(userName).isPresent();
    }

    public Boolean validateExistsLogin(String userName, String password) {
        Login login = loginRepository.findByUserName(userName).orElse(null);
        if (login == null) {
            return false;
        } else {
            String generatedHash = loginRepository.generateHashSenha(userName, password, login.getPwdUUID());
            return generatedHash.equals(login.getPwdHash());
        }
    }

}
