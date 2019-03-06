package org.springframework.samples.petclinic.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.samples.petclinic.model.Visit;

@Mapper
public interface VisitMapper {
  @Select("SELECT * FROM visits WHERE pet_id = #{petId}")
  List<Visit> findByPetId(Integer petId);
}
