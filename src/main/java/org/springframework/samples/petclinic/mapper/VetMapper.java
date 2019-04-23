package org.springframework.samples.petclinic.mapper;

import java.util.Collection;
import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Vet;

@Mapper
public interface VetMapper {
  @Select("SELECT * FROM vets")
  @Results({
    @Result(property = "id", column = "id"),
    @Result(property = "firstName",  column = "first_name"),
    @Result(property = "lastName",  column = "last_name"),
    @Result(property = "specialties", javaType=Set.class, column = "id",
    many=@Many(fetchType=FetchType.EAGER, select="org.springframework.samples.petclinic.mapper.SpecialtyMapper.findByVetId")),
  })
  Collection<Vet> findAll() throws DataAccessException;
  
  @Select("SELECT * FROM vets WHERE id = #{id}")
  @Results({
    @Result(property = "id", column = "id"),
    @Result(property = "firstName",  column = "first_name"),
    @Result(property = "lastName",  column = "last_name"),
    @Result(property = "specialties", javaType=Set.class, column = "id",
    many=@Many(fetchType=FetchType.EAGER, select="org.springframework.samples.petclinic.mapper.SpecialtyMapper.findByVetId")),
  })
  Vet findById(int id) throws DataAccessException;

  void save(Vet vet) throws DataAccessException;
  
  @Delete("DELETE FROM vets WHERE id = #{id}")
  void delete(Vet vet) throws DataAccessException;
}
