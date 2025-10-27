package org.upcy.simbia.mapper;

import org.upcy.simbia.api.industry.input.IndustryRequestDto;
import org.upcy.simbia.api.industry.output.IndustryResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.Industry;

public class IndustryMapper extends AbstractMapper<Industry, IndustryRequestDto, IndustryResponseDto> {

    private static final LoginMapper loginMapper = new LoginMapper();

    public Industry toEntity(IndustryRequestDto requestDto) {
        return Industry.builder()
                .cnpj(requestDto.getCnpj())
                .industryName(requestDto.getIndustryName())
                .description(requestDto.getDescription())
                .contactMail(requestDto.getContactMail())
                .city(requestDto.getCity())
                .cep(requestDto.getCep())
                .latitude(requestDto.getLatitude())
                .longitude(requestDto.getLongitude())
                .state(requestDto.getState())
                .image(requestDto.getImage())
                .active("1")
                .build();
    }

    public IndustryResponseDto toResponse(Industry model) {
        return IndustryResponseDto.builder()
                .idIndustry(model.getId())
                .cnpj(model.getCnpj())
                .industryType(model.getIndustryType())
                .plan(model.getPlan())
                .login(loginMapper.toResponse(model.getLogin()))
                .industryName(model.getIndustryName())
                .description(model.getDescription())
                .contactMail(model.getContactMail())
                .city(model.getCity())
                .cep(model.getCep())
                .latitude(model.getLatitude())
                .longitude(model.getLongitude())
                .state(model.getState())
                .image(model.getImage())
                .build();
    }

}
