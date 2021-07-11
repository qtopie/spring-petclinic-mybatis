/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.owner;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author qtopierw
 */
@Service
public class OwnerServiceImpl implements OwnerService {
  
  private final OwnerMapper ownerMapper;

  /**
   * @param ownerMapper
   */
  public OwnerServiceImpl(OwnerMapper ownerMapper) {
    this.ownerMapper = ownerMapper;
  }

  @Override
  public Page<Owner> getOwners(Pageable pageable) {
    List<Owner> owners = ownerMapper.findOwner();
    return new PageImpl<>(owners, pageable, 0);
  }

  @Override
  public void saveOrUpdate(Owner owner) {
    Objects.requireNonNull(owner);

    ownerMapper.saveOrUpdate(owner);
  }

  
}
