package org.upcy.simbia.mapper;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import java.util.Map;

public abstract class AbstractMapper<E, Req, Res> {
    public abstract E toEntity(Req requestDto);
    public abstract Res toResponse(E entity);

    protected ObjectMapper objectMapper = new ObjectMapper();

    public void updateFromMap(E entity, Map<String, Object> mapFields) throws JsonMappingException {
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        objectMapper.updateValue(entity, mapFields);
    }

}
