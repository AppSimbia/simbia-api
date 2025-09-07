package org.upcy.simbia.service;

import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.IndustryDto;
import org.upcy.simbia.model.Industry;
import org.upcy.simbia.model.IndustryType;
import org.upcy.simbia.model.Login;
import org.upcy.simbia.model.Plan;
import org.upcy.simbia.repository.IndustryRepository;
import org.upcy.simbia.repository.IndustryTypeRepository;
import org.upcy.simbia.repository.PlanRepository;
import org.upcy.simbia.repository.LoginRepository;

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

    public Industry create(IndustryDto dto) {
        Industry industry = new Industry();
        industry.setIndustryType(getIndustryType(dto.getIndustryType()));
        industry.setPlan(getPlan(dto.getPlan()));
        industry.setLogin(getLogin(dto.getLogin()));
        industry.setCnpj(dto.getCnpj());
        industry.setIndustryName(dto.getIndustryName());
        industry.setDescription(dto.getDescription());
        industry.setContactMail(dto.getContactMail());
        industry.setCep(dto.getCep());
        industry.setCity(dto.getCity());
        industry.setState(dto.getState());
        industry.setImage(dto.getImage());
        industry.setActive("1");
        return industryRepository.save(industry);
    }

    public Optional<Industry> findById(Long id) {
        return industryRepository.findById(id)
                .filter(industry -> "1".equals(industry.getActive()));
    }

    public Optional<Industry> update(Long id, IndustryDto dto) {
        return industryRepository.findById(id).map(existing -> {
            existing.setIndustryType(getIndustryType(dto.getIndustryType()));
            existing.setPlan(getPlan(dto.getPlan()));
            existing.setLogin(getLogin(dto.getLogin()));
            existing.setCnpj(dto.getCnpj());
            existing.setIndustryName(dto.getIndustryName());
            existing.setDescription(dto.getDescription());
            existing.setContactMail(dto.getContactMail());
            existing.setCep(dto.getCep());
            existing.setCity(dto.getCity());
            existing.setState(dto.getState());
            existing.setImage(dto.getImage());
            return industryRepository.save(existing);
        });
    }

    public boolean delete(Long id) {
        return industryRepository.findById(id).map(existing -> {
            existing.setActive("0");
            industryRepository.save(existing);
            return true;
        }).orElse(false);
    }

    private IndustryType getIndustryType(Long id) {
        return industryTypeRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("IndustryType não encontrado: " + id)
        );
    }

    private Plan getPlan(Long id) {
        return planRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Plan não encontrado: " + id)
        );
    }

    private Login getLogin(Long id) {
        return loginRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Login não encontrado: " + id)
        );
    }
}
