/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.pet;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/** @author qtopierw */
@Mapper
public interface PetMapper {
  /**
   * Find Pet by ID
   * @param id
   * @return
   */
  Pet findById(Integer id);

  /**
   * Find Pet by owner ID
   * @param ownerId
   * @return
   */
  List<Pet> findByOwnerId(Integer ownerId);
  
  /**
   * Find Pet Type by type ID
   * @param typeId
   * @return @link{PetType}
   */
  PetType findPetTypeByTypeId(Integer typeId);
}
