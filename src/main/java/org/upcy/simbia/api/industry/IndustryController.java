package org.upcy.simbia.api.industry;

import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.api.industry.input.IndustryRequestDto;
import org.upcy.simbia.api.industry.input.LoginIndustryDto;
import org.upcy.simbia.api.industry.output.IndustryResponseDto;
import org.upcy.simbia.dataprovider.persistence.entity.IndustryType;
import org.upcy.simbia.service.IndustryService;
import org.upcy.simbia.service.IndustryTypeService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class IndustryController implements IndustryContract {

    private final IndustryService industryService;
    private final IndustryTypeService industryTypeService;

    @Override
    public ResponseEntity<IndustryResponseDto> save(IndustryRequestDto dto) {
        return ResponseEntity.status(201).body(industryService.save(dto));
    }

    @Override
    public ResponseEntity<IndustryResponseDto> loginIndustry(LoginIndustryDto request) {
        return ResponseEntity.status(200).body(industryService.loginIndustry(request));
    }

    @Override
    public ResponseEntity<IndustryResponseDto> findIndustryByCnpj(String cnpj) {
        return ResponseEntity.ok(industryService.findIndustryByCnpj(cnpj));
    }

    @Override
    public ResponseEntity<IndustryResponseDto> findIndustryById(Long id) {
        return ResponseEntity.ok(industryService.findById(id));
    }

    @Override
    public ResponseEntity<List<IndustryType>> findAllIndustriesTypes() {
        return ResponseEntity.ok(industryTypeService.findAll());
    }

    @Override
    public ResponseEntity<IndustryResponseDto> updateIndustry(String cnpj, Map<String, Object> dto) throws JsonMappingException {
        return ResponseEntity.ok(industryService.update(cnpj, dto));
    }
}
