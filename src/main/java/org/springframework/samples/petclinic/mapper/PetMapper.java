package org.springframework.samples.petclinic.mapper;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;

/**
 * 
 * @author artificerpi
 *
 */

@Mapper
public interface PetMapper {

  @Select("SELECT * FROM types")
  List<PetType> findPetTypes() throws DataAccessException;

  @Select("SELECT * FROM pets WHERE id = #{id}")
  @Results({
    @Result(property = "birthDate",  column = "birth_date", javaType = Date.class),
    @Result(property = "type",  column = "type_id", javaType = PetType.class,
      one=@One(select="org.springframework.samples.petclinic.mapper.PetTypeMapper.findById")),
    @Result(property = "owner",  column = "owner_id", javaType = Owner.class,
      one=@One(select="org.springframework.samples.petclinic.mapper.OwnerMapper.findById")),
    @Result(property = "visits",  column = "pet_id",
      many=@Many(fetchType=FetchType.EAGER, select="org.springframework.samples.petclinic.mapper.VisitMapper.findByPetId")),
  })
  Pet findById(int id) throws DataAccessException;

  void save(Pet pet) throws DataAccessException;
  
  @Select("SELECT * FROM pets")
  @ResultType(value = Collection.class)
  Collection<Pet> findAll() throws DataAccessException;

  @Delete("DELETE FROM pets WHERE id= #{pet.id}")
  void delete(Pet pet) throws DataAccessException;
}
