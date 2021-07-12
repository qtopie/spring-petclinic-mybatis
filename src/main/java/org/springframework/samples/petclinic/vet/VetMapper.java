/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.vet;

import java.util.Set;

import org.apache.ibatis.annotations.Mapper;

/** @author qtopierw */
@Mapper
public interface VetMapper {
  
  /**
   * Find Vet by ID
   * @param id
   * @return
   */
  Vet findById(Integer id);

  Set<Specialty> findSpecialtiesByVetId(Integer vetId);
}
