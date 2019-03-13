package org.springframework.samples.petclinic.mapper;

import java.util.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Vet;

@Mapper
public interface VetMapper {
  Collection<Vet> findAll() throws DataAccessException;
  
  Vet findById(int id) throws DataAccessException;

  void save(Vet vet) throws DataAccessException;
  
  void delete(Vet vet) throws DataAccessException;
}
