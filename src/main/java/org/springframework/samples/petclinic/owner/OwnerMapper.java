/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.owner;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
/** @author qtopierw */
@Mapper
public interface OwnerMapper {
  
  
  /**
   * find all owners
   * @return
   */
  List<Owner> findOwner();

  /**
   * save or update owner
   */
  void saveOrUpdate(Owner owner);
}
