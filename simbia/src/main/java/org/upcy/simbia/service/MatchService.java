package org.upcy.simbia.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.MatchDto;
import org.upcy.simbia.model.*;
import org.upcy.simbia.repository.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final EmployeeRepository employeeRepository;
    private final PostRepository postRepository;
    private final IndustryRepository industryRepository;

    public Match create(MatchDto dto) {
        Employee employee = employeeRepository.findById(dto.getEmployee())
                .orElseThrow(() -> new RuntimeException("Employee não encontrado"));

        Post post = postRepository.findById(dto.getPost())
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        Industry origin = industryRepository.findById(dto.getIndustryOrigin())
                .orElseThrow(() -> new RuntimeException("Industry origin não encontrada"));

        Industry destine = industryRepository.findById(dto.getIndustryDestine())
                .orElseThrow(() -> new RuntimeException("Industry destine não encontrada"));

        Match match = new Match();
        match.setEmployee(employee);
        match.setPost(post);
        match.setIndustryOrigin(origin);
        match.setIndustryDestine(destine);
        match.setStatus("1");

        return matchRepository.save(match);
    }

    public List<Match> findAll() {
        return matchRepository.findAll();
    }

    public Match findById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Match não encontrado"));
    }

    public Match update(Long id, MatchDto dto) {
        Match match = findById(id);

        Employee employee = employeeRepository.findById(dto.getEmployee())
                .orElseThrow(() -> new RuntimeException("Employee não encontrado"));

        Post post = postRepository.findById(dto.getPost())
                .orElseThrow(() -> new RuntimeException("Post não encontrado"));

        Industry origin = industryRepository.findById(dto.getIndustryOrigin())
                .orElseThrow(() -> new RuntimeException("Industry origin não encontrada"));

        Industry destine = industryRepository.findById(dto.getIndustryDestine())
                .orElseThrow(() -> new RuntimeException("Industry destine não encontrada"));

        match.setEmployee(employee);
        match.setPost(post);
        match.setIndustryOrigin(origin);
        match.setIndustryDestine(destine);

        return matchRepository.save(match);
    }

    public void delete(Long id) {
        Match match = findById(id);
        matchRepository.delete(match);
    }

    public Match updateStatus(Long id, String status) {
        if (!status.matches("[1-4]")) {
            throw new RuntimeException("Status inválido. Deve ser 1,2,3 ou 4");
        }
        Match match = findById(id);
        match.setStatus(status);
        return matchRepository.save(match);
    }
}
