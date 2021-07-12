/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.vet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/** @author qtopierw */
@RequestMapping("/api/vets")
public class VetController {
  @Autowired
  private VetMapper vetMapper;

  @GetMapping("/{id}")
  public Vet getById(@PathVariable Integer id) {
    return vetMapper.findById(id);
  }
}
