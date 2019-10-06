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
import org.springframework.samples.petclinic.model.Owner;

@Mapper
public interface OwnerMapper {

  Collection<Owner> findByLastName(String lastName) throws DataAccessException;
  
  @Select("SELECT * FROM owners WHERE id = #{id}")
  @Results({
	// need to add this or the id field will be blank (duplicated in mapping to ownerId for pet
	@Result(property = "id",  column = "id"),
    @Result(property = "firstName",  column = "first_name"),
    @Result(property = "lastName",  column = "last_name"),
    @Result(property = "pets", column = "id", javaType=Set.class, many=@Many(fetchType=FetchType.EAGER,
      select="org.springframework.samples.petclinic.mapper.PetMapper.findByOwnerId")),
  })
  Owner findById(int id) throws DataAccessException;
  
  void save(Owner owner) throws DataAccessException;
  
  @Select("SELECT * FROM owners")
  @Results({
	@Result(property = "id",  column = "id"),
    @Result(property = "firstName",  column = "first_name"),
    @Result(property = "lastName",  column = "last_name"),
    @Result(property = "pets", column = "id", many=@Many(fetchType=FetchType.EAGER,
    select="org.springframework.samples.petclinic.mapper.PetMapper.findByOwnerId")),
  })
  Collection<Owner> findAll() throws DataAccessException;
  
  @Delete("DELETE FROM owners WHERE id = #{id}")
  void delete(Owner owner) throws DataAccessException;
  
}
