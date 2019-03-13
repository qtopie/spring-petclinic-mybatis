package org.springframework.samples.petclinic.mapper;

import java.util.Collection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Specialty;

@Mapper
public interface SpecialtyMapper {
  Specialty findById(int id) throws DataAccessException;
  
  Collection<Specialty> findAll() throws DataAccessException;
  
  void save(Specialty specialty) throws DataAccessException;
  
  void delete(Specialty specialty) throws DataAccessException;
}
