package org.upcy.simbia.service;

import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.Map;

public interface CrudService<E, ID, Req, Res> {

    Res save(Req request);
    Res findById(ID id);
    Res update(ID id, Map<String, Object> map) throws JsonMappingException;
    void delete(ID id);
    java.util.List<Res> findAll();
    E findEntityById(ID id);

}
