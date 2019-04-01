package org.springframework.samples.petclinic.mapper;

import java.util.Collection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.PetType;

@Mapper
public interface PetTypeMapper {
  
  @Select("SELECT * FROM types WHERE id = #{id}")
  PetType findById(int id) throws DataAccessException;
  
  @Select("SELECT * FROM types ORDER BY name")
  Collection<PetType> findAll() throws DataAccessException;

  @Insert({"INSERT INTO types(id,name) values(#{id}, #{name})", 
      "ON DUPLICATE KEY UPDATE name=#{name}"})
  @Options(useGeneratedKeys=true, keyProperty="id")
  void save(PetType petType) throws DataAccessException;
  
  @Delete("DELETE FROM types WHERE id= #{id}")
  void delete(PetType petType) throws DataAccessException;

}
