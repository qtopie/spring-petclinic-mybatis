package org.springframework.samples.petclinic.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.User;

@Mapper
public interface UserMapper {
  // TODO refactor user-role many to many relation
  void save(User user) throws DataAccessException;
}
