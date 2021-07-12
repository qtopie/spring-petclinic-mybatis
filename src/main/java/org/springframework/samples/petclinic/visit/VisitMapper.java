/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.visit;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/** @author qtopierw */
@Mapper
public interface VisitMapper {
  
  /**
   * Find Visit by ID
   * @param id
   * @return
   */
  Visit findById(Integer id);

  /**
   * Find by Pet ID
   * @param petId
   * @return
   */
  List<Visit> findByPetId(Integer petId);
}
