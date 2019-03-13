package org.springframework.samples.petclinic.mapper;

import java.util.Collection;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Visit;

@Mapper
public interface VisitMapper {

  void save(Visit visit) throws DataAccessException;

  @Select("SELECT * FROM visits WHERE pet_id = #{petId}")
  List<Visit> findByPetId(Integer petId);
  
  @Select("SELECT * FROM visits WHERE id = #{id}")
  Visit findById(int id) throws DataAccessException;
  
  @Select("SELECT * FROM visits")
  Collection<Visit> findAll() throws DataAccessException;

  @Delete("DELETE FROM visits WHERE id = #{visit.id}")
  void delete(Visit visit) throws DataAccessException;
}
