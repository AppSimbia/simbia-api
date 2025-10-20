package org.upcy.simbia.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.api.industry.input.IndustryRequestDto;
import org.upcy.simbia.api.industry.output.IndustryResponseDto;
import org.upcy.simbia.dataprovider.client.cnpj.CnpjClient;
import org.upcy.simbia.dataprovider.client.cnpj.dto.WsData;
import org.upcy.simbia.dataprovider.persistence.entity.Industry;
import org.upcy.simbia.dataprovider.persistence.entity.IndustryType;
import org.upcy.simbia.dataprovider.persistence.entity.Login;
import org.upcy.simbia.dataprovider.persistence.entity.Plan;
import org.upcy.simbia.dataprovider.persistence.repository.IndustryRepository;
import org.upcy.simbia.dataprovider.persistence.repository.IndustryTypeRepository;
import org.upcy.simbia.mapper.IndustryMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IndustryService implements CrudService<Industry, Long, IndustryRequestDto, IndustryResponseDto> {

    private static final IndustryMapper industryMapper = new IndustryMapper();
    private final LoginService loginService;
    private final PlanService planService;
    private final CnpjClient cnpjClient;
    private final IndustryRepository industryRepository;
    private final IndustryTypeRepository industryTypeRepository;

    @Override
    public IndustryResponseDto save(IndustryRequestDto request) {
        Industry industry = toIndustry(request);

        WsData wsData = cnpjClient.getDomainByCnpj(request.getCnpj());
        if (wsData.getEmails().stream().noneMatch(email -> request.getContactMail().endsWith(email.getDomain()))){
            throw new RuntimeException("Contact email domain does not match any of the CNPJ email domains");
        }

        mapRelationships(industry, request);
        industry.setId(industryRepository.generateId());
        return toResponse(industryRepository.save(industry));
    }

    @Override
    public IndustryResponseDto findById(Long id) {
        return toResponse(findEntityById(id));
    }

    @Override
    public IndustryResponseDto update(Long id, Map<String, Object> map) throws JsonMappingException {
        Industry industry = industryRepository.findById(id)
                .filter(i -> "1".equals(i.getActive()))
                .orElseThrow(EntityNotFoundException::new);
        industryMapper.updateFromMap(industry, map);

        return toResponse(industryRepository.save(industry));
    }

    public IndustryResponseDto update(String cnpj, Map<String, Object> map) throws JsonMappingException {
        Industry industry = industryRepository.findIndustryByCnpj(cnpj)
                .filter(i -> "1".equals(i.getActive()))
                .orElseThrow(EntityNotFoundException::new);
        industryMapper.updateFromMap(industry, map);

        return toResponse(industryRepository.save(industry));
    }

    @Override
    public void delete(Long id) {
        Industry industry = findEntityById(id);
        industry.setActive("0");
        industryRepository.save(industry);
    }

    @Override
    public List<IndustryResponseDto> findAll() {
        return industryRepository.findAll().stream()
                .filter(industry -> "1".equals(industry.getActive()))
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Industry findEntityById(Long id) {
        return industryRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Industry not found with ID: " + id));
    }

    public IndustryResponseDto loginIndustry(String username, String password) {
        Boolean isAuthenticated = loginService.validateExistsLogin(username, password);
        if (!isAuthenticated) {
            throw new RuntimeException("Invalid username or password");
        }

        Industry industry = industryRepository.findIndustryByCnpj(username)
                .orElseThrow(() -> new EntityNotFoundException("Industry not found with CNPJ: " + username));

        return toResponse(industry);
    }

    public IndustryResponseDto findIndustryByCnpj(String cnpj) {
        return toResponse(industryRepository.findIndustryByCnpj(cnpj).orElseThrow(() ->
                new EntityNotFoundException("Industry not found with CNPJ: " + cnpj)));
    }

    private void mapRelationships(Industry industry, IndustryRequestDto dto) {
        IndustryType industryType = industryTypeRepository.findById(dto.getIdIndustryType())
                .orElseThrow(() -> new EntityNotFoundException("IndustryType not found: " + dto.getIdIndustryType()));
        Plan plan = planService.findEntityById(dto.getIdPlan());
        Login login = loginService.createLogin(dto.getCnpj(), dto.getPassword());

        industry.setIndustryType(industryType);
        industry.setPlan(plan);
        industry.setLogin(login);
    }

    private Industry toIndustry(IndustryRequestDto requestDto) {
        return industryMapper.toEntity(requestDto);
    }

    private IndustryResponseDto toResponse(Industry industry) {
        return industryMapper.toResponse(industry);
    }

}
