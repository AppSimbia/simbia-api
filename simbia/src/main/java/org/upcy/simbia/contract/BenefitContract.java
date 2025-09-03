package org.upcy.simbia.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.BenefitDto;

import java.util.List;

@RequestMapping("/benefits")
public interface BenefitContract {

    @PostMapping
    ResponseEntity<BenefitDto> create(@RequestBody BenefitDto dto);

    @GetMapping("/{id}")
    ResponseEntity<BenefitDto> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<BenefitDto>> findAll();

    @PutMapping("/{id}")
    ResponseEntity<BenefitDto> update(@PathVariable Long id, @RequestBody BenefitDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
