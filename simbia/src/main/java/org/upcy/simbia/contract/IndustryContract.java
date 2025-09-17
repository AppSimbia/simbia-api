package org.upcy.simbia.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.IndustryDto;
import org.upcy.simbia.model.Industry;

import java.util.Optional;

@RequestMapping("/industries")
public interface IndustryContract {

    @PostMapping
    ResponseEntity<Industry> create(@RequestBody IndustryDto dto);

    @GetMapping("/{id}")
    ResponseEntity<Optional<Industry>> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<Optional<Industry>> update(@PathVariable Long id, @RequestBody IndustryDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);
}
