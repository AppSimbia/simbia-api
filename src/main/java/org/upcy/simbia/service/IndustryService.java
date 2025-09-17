package org.upcy.simbia.service;

import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.IndustryRequestDto;
import org.upcy.simbia.dto.response.IndustryResponseDto;
import org.upcy.simbia.model.Industry;
import org.upcy.simbia.model.IndustryType;
import org.upcy.simbia.model.Login;
import org.upcy.simbia.model.Plan;
import org.upcy.simbia.repository.IndustryRepository;
import org.upcy.simbia.repository.IndustryTypeRepository;
import org.upcy.simbia.repository.PlanRepository;
import org.upcy.simbia.repository.LoginRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import java.util.Optional;

@Service
public class IndustryService {

    private final IndustryRepository industryRepository;
    private final IndustryTypeRepository industryTypeRepository;
    private final PlanRepository planRepository;
    private final LoginRepository loginRepository;

    public IndustryService(IndustryRepository industryRepository,
                           IndustryTypeRepository industryTypeRepository,
                           PlanRepository planRepository,
                           LoginRepository loginRepository) {
        this.industryRepository = industryRepository;
        this.industryTypeRepository = industryTypeRepository;
        this.planRepository = planRepository;
        this.loginRepository = loginRepository;
    }

    public IndustryResponseDto createIndustry(IndustryRequestDto dto) {
        Industry industry = new Industry();
        industry.setIndustryType(getIndustryType(dto.getIdIndustryType()));
        industry.setIdPlan(getPlan(dto.getIdPlan()));
        industry.setIdLogin(getLogin(dto.getIdLogin()));
        industry.setCnpj(dto.getCnpj());
        industry.setIndustryName(dto.getIndustryName());
        industry.setDescription(dto.getDescription());
        industry.setContactMail(dto.getContactMail());
        industry.setCep(dto.getCep());
        industry.setCity(dto.getCity());
        industry.setState(dto.getState());
        industry.setImage(dto.getImage());
        industry.setActive("1");

        Industry saved = industryRepository.save(industry);
        return toDto(saved);
    }

    public Optional<IndustryResponseDto> findIndustryById(Long id) {
        return industryRepository.findById(id)
                .filter(industry -> "1".equals(industry.getActive()))
                .map(this::toDto);
    }

    @Transactional
    public Optional<IndustryResponseDto> updateIndustry(Long id, IndustryRequestDto dto) {
        return industryRepository.findById(id).map(existing -> {
            existing.setIndustryType(getIndustryType(dto.getIdIndustryType()));
            existing.setIdPlan(getPlan(dto.getIdPlan()));
            existing.setIdLogin(getLogin(dto.getIdLogin()));
            existing.setCnpj(dto.getCnpj());
            existing.setIndustryName(dto.getIndustryName());
            existing.setDescription(dto.getDescription());
            existing.setContactMail(dto.getContactMail());
            existing.setCep(dto.getCep());
            existing.setCity(dto.getCity());
            existing.setState(dto.getState());
            existing.setImage(dto.getImage());
            return toDto(industryRepository.save(existing));
        });
    }

    public boolean deleteIndustry(Long id) {
        return industryRepository.findById(id).map(existing -> {
            existing.setActive("0");
            industryRepository.save(existing);
            return true;
        }).orElse(false);
    }

    private IndustryType getIndustryType(Long id) {
        return industryTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("IndustryType not found: " + id));
    }

    private Plan getPlan(Long id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan not found: " + id));
    }

    private Login getLogin(Long id) {
        return loginRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Login not found: " + id));
    }

    private IndustryResponseDto toDto(Industry industry) {
        IndustryResponseDto dto = new IndustryResponseDto();
        dto.setIdIndustryType(industry.getIndustryType().getIdIndustryType());
        dto.setIdPlan(industry.getIdPlan().getIdPlan());
        dto.setIdLogin(industry.getIdLogin().getIdLogin());
        dto.setCnpj(industry.getCnpj());
        dto.setIndustryName(industry.getIndustryName());
        dto.setDescription(industry.getDescription());
        dto.setContactMail(industry.getContactMail());
        dto.setCep(industry.getCep());
        dto.setCity(industry.getCity());
        dto.setState(industry.getState());
        dto.setImage(industry.getImage());
        return dto;
    }
}
