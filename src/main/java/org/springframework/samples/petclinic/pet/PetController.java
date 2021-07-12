/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author qtopierw */
@RestController
@RequestMapping("/api/pets")
public class PetController {
  @Autowired
  private PetMapper petMapper;

  @GetMapping("/{id}")
  public Pet getById(@PathVariable Integer id) {
    return petMapper.findById(id);
  }
}
