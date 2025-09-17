package org.upcy.simbia.contract;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.upcy.simbia.dto.MatchDto;
import org.upcy.simbia.model.Match;

import java.util.List;

@RequestMapping("/matches")
public interface MatchContract {

    @PostMapping
    ResponseEntity<Match> create(@RequestBody MatchDto dto);

    @GetMapping
    ResponseEntity<List<Match>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<Match> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<Match> update(@PathVariable Long id, @RequestBody MatchDto dto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable Long id);

    @PatchMapping("/{id}/status")
    ResponseEntity<Match> updateStatus(@PathVariable Long id, @RequestParam String status);
}
