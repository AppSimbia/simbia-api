package org.upcy.simbia.api.industry;

import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.api.industry.input.IndustryRequestDto;
import org.upcy.simbia.api.industry.output.IndustryResponseDto;
import org.upcy.simbia.service.IndustryService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class IndustryController implements IndustryContract {

    private final IndustryService industryService;

    @Override
    public ResponseEntity<IndustryResponseDto> save(IndustryRequestDto dto) {
        return ResponseEntity.status(201).body(industryService.save(dto));
    }

    @Override
    public ResponseEntity<IndustryResponseDto> loginIndustry(String username, String password) {
        return ResponseEntity.status(200).body(industryService.loginIndustry(username, password));
    }

    @Override
    public ResponseEntity<IndustryResponseDto> findIndustryByCnpj(String cnpj) {
        return ResponseEntity.ok(industryService.findIndustryByCnpj(cnpj));
    }

    @Override
    public ResponseEntity<IndustryResponseDto> updateIndustry(String cnpj, Map<String, Object> dto) throws JsonMappingException {
        return ResponseEntity.ok(industryService.update(cnpj, dto));
    }
}
