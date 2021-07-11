/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.owner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author qtopierw
 */
public interface OwnerService {
  
  /**
   * Get owners by page
   * @param pageable
   * @return
   */
  Page<Owner> getOwners(Pageable pageable);
}
