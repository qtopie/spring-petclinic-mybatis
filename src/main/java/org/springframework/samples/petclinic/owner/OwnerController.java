/*
 * Copyright (C) 2021 qtopie.rw
 *
 * Licensed under MIT License
 */

package org.springframework.samples.petclinic.owner;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @author qtopierw */
@RequestMapping("/api/owners")
@RestController
public class OwnerController {

  @Autowired private OwnerService ownerService;

  @GetMapping
  public List<Owner> getOwners() {
    return ownerService.getOwners(PageRequest.of(0, 1000)).getContent();
  }

  @PostMapping
  public void addOwner(@Valid @RequestBody Owner owner) {
    ownerService.saveOrUpdate(owner);
  }

  @PutMapping("/{ownerId}")
  public void updateOwner(@PathVariable Integer ownerId, @Valid @RequestBody Owner owner) {
    owner.setId(ownerId);
    ownerService.saveOrUpdate(owner);
  }
}
