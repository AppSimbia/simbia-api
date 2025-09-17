package org.upcy.simbia.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.upcy.simbia.contract.MatchContract;
import org.upcy.simbia.dto.request.MatchRequestDto;
import org.upcy.simbia.dto.response.MatchResponseDto;
import org.upcy.simbia.service.MatchService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MatchController implements MatchContract {

    private final MatchService matchService;

    @Override
    public ResponseEntity<MatchResponseDto> create(MatchRequestDto dto) {
        return ResponseEntity.status(201).body(matchService.insertMatch(dto));
    }

    @Override
    public ResponseEntity<List<MatchResponseDto>> findAll() {
        return ResponseEntity.ok(matchService.listMatches());
    }

    @Override
    public ResponseEntity<MatchResponseDto> findById(Long id) {
        return ResponseEntity.ok(matchService.findMatch(id));
    }

    @Override
    public ResponseEntity<MatchResponseDto> update(Long id, MatchRequestDto dto) {
        return ResponseEntity.ok(matchService.updateMatch(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<MatchResponseDto> updateStatus(Long id, String status) {
        return ResponseEntity.ok(matchService.updateStatus(id, status));
    }
}
