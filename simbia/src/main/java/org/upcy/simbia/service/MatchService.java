package org.upcy.simbia.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dto.request.MatchRequestDto;
import org.upcy.simbia.dto.response.MatchResponseDto;
import org.upcy.simbia.model.Employee;
import org.upcy.simbia.model.Industry;
import org.upcy.simbia.model.Match;
import org.upcy.simbia.model.Post;
import org.upcy.simbia.repository.EmployeeRepository;
import org.upcy.simbia.repository.IndustryRepository;
import org.upcy.simbia.repository.MatchRepository;
import org.upcy.simbia.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final EmployeeRepository employeeRepository;
    private final PostRepository postRepository;
    private final IndustryRepository industryRepository;
    private final ObjectMapper objectMapper;

    private MatchResponseDto toDto(Match entity) {
        return objectMapper.convertValue(entity, MatchResponseDto.class);
    }

    private Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));
    }

    private Post getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post not found"));
    }

    private Industry getIndustry(Long id) {
        return industryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Industry not found"));
    }

    public List<MatchResponseDto> listMatches() {
        return matchRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public MatchResponseDto findMatch(Long id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match not found"));
        return toDto(match);
    }

    public MatchResponseDto insertMatch(@Valid MatchRequestDto dto) {
        Employee employee = getEmployee(dto.getIdEmployee());
        Post post = getPost(dto.getIdPost());
        Industry origin = getIndustry(dto.getIndustryOrigin());
        Industry destine = getIndustry(dto.getIndustryDestine());

        Match entity = new Match();
        entity.setEmployee(employee);
        entity.setPost(post);
        entity.setIndustryOrigin(origin);
        entity.setIndustryDestine(destine);
        entity.setStatus("1");

        matchRepository.save(entity);
        return toDto(entity);
    }

    @Transactional
    public MatchResponseDto updateMatch(Long id, @Valid MatchRequestDto dto) {
        Match existing = matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match not found"));

        Employee employee = getEmployee(dto.getIdEmployee());
        Post post = getPost(dto.getIdPost());
        Industry origin = getIndustry(dto.getIndustryOrigin());
        Industry destine = getIndustry(dto.getIndustryDestine());

        existing.setEmployee(employee);
        existing.setPost(post);
        existing.setIndustryOrigin(origin);
        existing.setIndustryDestine(destine);

        matchRepository.save(existing);
        return toDto(existing);
    }

    public void deleteMatch(Long id) {
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match not found"));
        matchRepository.delete(match);
    }

    public MatchResponseDto updateStatus(Long id, String status) {
        if (!status.matches("[1-4]")) {
            throw new IllegalArgumentException("Invalid status. Must be 1, 2, 3 or 4");
        }
        Match match = matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match not found"));

        match.setStatus(status);
        matchRepository.save(match);
        return toDto(match);
    }
}
