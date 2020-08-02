package org.springframework.samples.petclinic.mapper;

import java.util.Collection;
import java.util.Set;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Specialty;

@Mapper
public interface SpecialtyMapper {
  @Select("SELECT * FROM specialties WHERE id = #{id}")
  Specialty findById(int id) throws DataAccessException;

  @Select({
    "SELECT DISTINCT id, name FROM specialties WHERE id IN(",
    "SELECT specialty_id FROM vet_specialties WHERE vet_id = #{vetId}",
    ")"
  })
  Set<Specialty> findByVetId(int vetId) throws DataAccessException;

  @Select("SELECT * FROM specialties")
  Collection<Specialty> findAll() throws DataAccessException;

  @Insert({
    "INSERT INTO specialties(id,name) values(#{id}, #{name})",
    "ON DUPLICATE KEY UPDATE name=#{name}"
  })
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void save(Specialty specialty) throws DataAccessException;

  @Delete("DELETE FROM specialties WHERE id = #{id}")
  void delete(Specialty specialty) throws DataAccessException;
}
