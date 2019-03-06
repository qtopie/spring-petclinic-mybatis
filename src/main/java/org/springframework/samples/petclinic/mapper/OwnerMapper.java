package org.springframework.samples.petclinic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Owner;

@Mapper
public interface OwnerMapper {
  
  @Select("SELECT * FROM owners WHERE id = #{id}")
  @Results({
    @Result(property = "firstName",  column = "first_name"),
    @Result(property = "lastName",  column = "last_name"),
  })
  Owner findById(int id) throws DataAccessException;
}
