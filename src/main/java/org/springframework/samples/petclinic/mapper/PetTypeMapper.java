package org.springframework.samples.petclinic.mapper;

import java.util.Collection;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.PetType;

@Mapper
public interface PetTypeMapper {
  
  @Select("SELECT * FROM types WHERE id = #{id}")
  PetType findById(int id) throws DataAccessException;
  
  @Select("SELECT * FROM types")
  Collection<PetType> findAll() throws DataAccessException;

  @Insert({"INSERT INTO types(id,name) values(#{id}, #{name})", 
      "ON DUPLICATE KEY UPDATE name=#{name}"})
  void save(PetType petType) throws DataAccessException;
  
  @Delete({
    "DELETE FROM visits WHERE pet_id= #{id};",
    "DELETE FROM pets WHERE pet_id= #{id};",
    "DELETE FROM types WHERE id= #{id};",
    })
  void delete(PetType petType) throws DataAccessException;

}
