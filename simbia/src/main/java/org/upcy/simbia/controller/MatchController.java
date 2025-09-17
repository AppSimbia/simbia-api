package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.MatchContract;
import org.upcy.simbia.dto.MatchDto;
import org.upcy.simbia.model.Match;
import org.upcy.simbia.service.MatchService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchController implements MatchContract {

    private final MatchService matchService;

    @Override
    public ResponseEntity<Match> create(MatchDto dto) {
        return ResponseEntity.ok(matchService.create(dto));
    }

    @Override
    public ResponseEntity<List<Match>> findAll() {
        return ResponseEntity.ok(matchService.findAll());
    }

    @Override
    public ResponseEntity<Match> findById(Long id) {
        return ResponseEntity.ok(matchService.findById(id));
    }

    @Override
    public ResponseEntity<Match> update(Long id, MatchDto dto) {
        return ResponseEntity.ok(matchService.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        matchService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Match> updateStatus(Long id, String status) {
        return ResponseEntity.ok(matchService.updateStatus(id, status));
    }
}
