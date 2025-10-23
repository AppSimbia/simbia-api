package org.upcy.simbia.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import jakarta.transaction.Transactional;

import java.util.Map;

public interface CrudService<E, ID, Req, Res> {

    @Transactional
    Res save(Req request);
    Res findById(ID id);
    @Transactional
    Res update(ID id, Map<String, Object> map) throws JsonMappingException;
    void delete(ID id);
    java.util.List<Res> findAll();
    E findEntityById(ID id);

}
