package org.upcy.simbia.mapper;

import org.upcy.simbia.api.industry.output.LoginResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.Login;

public class LoginMapper extends AbstractMapper<Login, Object, LoginResponseDto>{
    @Override
    public Login toEntity(Object requestDto) {
        return null;
    }

    @Override
    public LoginResponseDto toResponse(Login entity) {
        return LoginResponseDto.builder()
                .id(entity.getId())
                .username(entity.getUserName())
                .pwdUUID(entity.getPwdUUID())
                .build();
    }
}
