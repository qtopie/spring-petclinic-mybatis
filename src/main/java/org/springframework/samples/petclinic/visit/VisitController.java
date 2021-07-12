/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author qtopierw */
@RestController
@RequestMapping("/api/visits")
public class VisitController {

  @Autowired
  private VisitMapper visitMapper;

  @GetMapping("/{id}")
  public Visit getById(@PathVariable Integer id) {
    return visitMapper.findById(id);
  }
  
}
