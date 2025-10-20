package org.upcy.simbia.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.upcy.simbia.dataprovider.persistence.entity.IndustryType;
import org.upcy.simbia.dataprovider.persistence.repository.IndustryTypeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IndustryTypeService {

    private final IndustryTypeRepository industryTypeRepository;

    public List<IndustryType> findAll(){
        return industryTypeRepository.findAll();
    }

    public IndustryType findEntityById(Long id){
        return industryTypeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Industry Type not found with id: " + id));
    }
}
