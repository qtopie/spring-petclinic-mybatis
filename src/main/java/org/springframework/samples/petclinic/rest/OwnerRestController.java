/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.springframework.samples.petclinic.rest;

import java.util.Collection;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.util.SwaggerConfig;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

/**
 * @author Vitaliy Fedoriv
 *
 */

@Api(value = "api/owners", authorizations = {@Authorization(SwaggerConfig.BEARER_API_KEY)})
@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/owners")
public class OwnerRestController {

  @Autowired
  private ClinicService clinicService;

  @ApiOperation(value = "/*/last/name/{lastName}",
      authorizations = {@Authorization(SwaggerConfig.BEARER_API_KEY)})
  @PreAuthorize("hasRole(@roles.OWNER_ADMIN)")
  @GetMapping(value = "/*/lastname/{lastName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Collection<Owner>> getOwnersList(
      @PathVariable("lastName") String ownerLastName) {
    if (ownerLastName == null) {
      ownerLastName = "";
    }
    Collection<Owner> owners = this.clinicService.findOwnerByLastName(ownerLastName);
    if (owners.isEmpty()) {
      return new ResponseEntity<Collection<Owner>>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Collection<Owner>>(owners, HttpStatus.OK);
  }

  @PreAuthorize("hasRole(@roles.OWNER_ADMIN)")
  @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Collection<Owner>> getOwners() {
    Collection<Owner> owners = this.clinicService.findAllOwners();
    if (owners.isEmpty()) {
      return new ResponseEntity<Collection<Owner>>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Collection<Owner>>(owners, HttpStatus.OK);
  }

  @PreAuthorize("hasRole(@roles.OWNER_ADMIN)")
  @GetMapping(value = "/{ownerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Owner> getOwner(@PathVariable("ownerId") int ownerId) {
    Owner owner = null;
    owner = this.clinicService.findOwnerById(ownerId);
    if (owner == null) {
      return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Owner>(owner, HttpStatus.OK);
  }

  @PreAuthorize("hasRole(@roles.OWNER_ADMIN)")
  @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Owner> addOwner(@RequestBody @Valid Owner owner,
      BindingResult bindingResult, UriComponentsBuilder ucBuilder) {
    BindingErrorsResponse errors = new BindingErrorsResponse();
    HttpHeaders headers = new HttpHeaders();
    if (bindingResult.hasErrors() || (owner == null)) {
      errors.addAllErrors(bindingResult);
      headers.add("errors", errors.toJSON());
      return new ResponseEntity<Owner>(headers, HttpStatus.BAD_REQUEST);
    }
    this.clinicService.saveOwner(owner);
    headers.setLocation(ucBuilder.path("/api/owners/{id}").buildAndExpand(owner.getId()).toUri());
    return new ResponseEntity<Owner>(owner, headers, HttpStatus.CREATED);
  }

  @PreAuthorize("hasRole(@roles.OWNER_ADMIN)")
  @PutMapping(value = "/{ownerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<Owner> updateOwner(@PathVariable("ownerId") int ownerId,
      @RequestBody @Valid Owner owner, BindingResult bindingResult,
      UriComponentsBuilder ucBuilder) {
    BindingErrorsResponse errors = new BindingErrorsResponse();
    HttpHeaders headers = new HttpHeaders();
    if (bindingResult.hasErrors() || (owner == null)) {
      errors.addAllErrors(bindingResult);
      headers.add("errors", errors.toJSON());
      return new ResponseEntity<Owner>(headers, HttpStatus.BAD_REQUEST);
    }
    Owner currentOwner = this.clinicService.findOwnerById(ownerId);
    if (currentOwner == null) {
      return new ResponseEntity<Owner>(HttpStatus.NOT_FOUND);
    }
    currentOwner.setAddress(owner.getAddress());
    currentOwner.setCity(owner.getCity());
    currentOwner.setFirstName(owner.getFirstName());
    currentOwner.setLastName(owner.getLastName());
    currentOwner.setTelephone(owner.getTelephone());
    this.clinicService.saveOwner(currentOwner);
    return new ResponseEntity<Owner>(currentOwner, HttpStatus.NO_CONTENT);
  }

  @PreAuthorize("hasRole(@roles.OWNER_ADMIN)")
  @DeleteMapping(value = "/{ownerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @Transactional
  public ResponseEntity<Void> deleteOwner(@PathVariable("ownerId") int ownerId) {
    Owner owner = this.clinicService.findOwnerById(ownerId);
    if (owner == null) {
      return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    this.clinicService.deleteOwner(owner);
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }

}
