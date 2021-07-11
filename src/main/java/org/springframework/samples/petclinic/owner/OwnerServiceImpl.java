/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.owner;

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

  
}
